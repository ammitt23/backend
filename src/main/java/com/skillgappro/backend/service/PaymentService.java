package com.skillgappro.backend.service;

import com.razorpay.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {

    private final RazorpayClient razorpayClient;

    public PaymentService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    public Map<String, Object> createOrder(int amount) throws Exception {

        JSONObject options = new JSONObject();

        // ✅ amount already in paise (frontend sends 1000 for ₹10)
        options.put("amount", amount);
        options.put("currency", "INR");
        options.put("receipt", "txn_" + System.currentTimeMillis());

        Order order = razorpayClient.orders.create(options);

        // ✅ RETURN CLEAN RESPONSE (VERY IMPORTANT)
        return Map.of(
                "orderId", order.get("id"),
                "amount", order.get("amount")
        );
    }
}


