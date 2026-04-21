package com.skillgappro.backend.util;

import java.time.LocalDate;

public class StreakUtil {

    public static boolean isNextDay(LocalDate lastDate) {
        return lastDate.plusDays(1).equals(LocalDate.now());
    }
}
