package com.skillgappro.backend.controller;

import com.skillgappro.backend.entity.Payment;
import com.skillgappro.backend.repository.PaymentRepository;
import com.skillgappro.backend.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin
public class PaymentController {

    private final PaymentService service;
    private final PaymentRepository repo;

    public PaymentController(PaymentService service, PaymentRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    // 🔥 CREATE ORDER
    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody Map<String, Object> data) {
        try {
            Number amountNumber = (Number) data.get("amount");

            if (amountNumber == null) {
                return ResponseEntity.badRequest().body("Amount is required");
            }

            int amount = amountNumber.intValue();

            System.out.println("💰 Creating order for amount: " + amount);

            Map<String, Object> order = service.createOrder(amount);

            return ResponseEntity.ok(order);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Payment failed");
        }
    }

    // 🔐 VERIFY PAYMENT + SAVE
    @PostMapping("/verify")
    public ResponseEntity<?> verifyPayment(@RequestBody Map<String, String> data) {
        try {
            String orderId = data.get("razorpay_order_id");
            String paymentId = data.get("razorpay_payment_id");
            String signature = data.get("razorpay_signature");
            String userIdStr = data.get("userId");

            // ✅ NULL CHECK
            if (orderId == null || paymentId == null || signature == null || userIdStr == null) {
                return ResponseEntity.badRequest().body("Missing payment data ❌");
            }

            Long userId = Long.parseLong(userIdStr);

            // 🔐 IMPORTANT: USE YOUR REAL SECRET KEY (NOT key_id)
            String secret = "YOUR_REAL_RAZORPAY_SECRET";

            String payload = orderId + "|" + paymentId;

            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(), "HmacSHA256"));
            byte[] hash = mac.doFinal(payload.getBytes());

            // ✅ FIX: CONVERT TO HEX (NOT BASE64)
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            String generatedSignature = hex.toString();

            // 🔍 DEBUG LOGS
            System.out.println("ORDER ID: " + orderId);
            System.out.println("PAYMENT ID: " + paymentId);
            System.out.println("SIGNATURE (FROM RAZORPAY): " + signature);
            System.out.println("GENERATED SIGNATURE: " + generatedSignature);

            // ❌ VERIFY
            if (!generatedSignature.equals(signature)) {
                return ResponseEntity.badRequest().body("Invalid signature ❌");
            }

            // ✅ SAVE PAYMENT
            Payment payment = new Payment();
            payment.setAmount(100); // ₹1 (adjust if needed)
            payment.setRazorpayOrderId(orderId);
            payment.setRazorpayPaymentId(paymentId);
            payment.setStatus("SUCCESS");
            payment.setStudentId(userId);

            repo.save(payment);

            return ResponseEntity.ok("Payment verified & saved ✅");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Verification failed ❌");
        }
    }

    // ✅ GET ALL PAYMENTS
    @GetMapping
    public List<Payment> getAll() {
        return repo.findAll();
    }

    // ✅ OPTIONAL SAVE
    @PostMapping("/save")
    public Payment save(@RequestBody Payment payment) {
        return repo.save(payment);
    }
}