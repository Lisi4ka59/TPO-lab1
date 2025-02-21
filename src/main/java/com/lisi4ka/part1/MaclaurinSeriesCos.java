package com.lisi4ka.part1;

public class MaclaurinSeriesCos {
        public static double cos(double x, int terms) {
            if (terms < 1) {
                throw new IllegalArgumentException("Количество членов ряда должно быть положительным (terms >= 1)");
            }
            if (Double.isNaN(x) || Double.isInfinite(x)) {
                throw new IllegalArgumentException("Аргумент x должен быть конечным числом");
            }
            if (Math.abs(x) >= 10) {
                throw new IllegalArgumentException("Аргумент x должен быть меньше 10 для сохранения точности");
            }
            if (Math.abs(x) >= 2 * terms) {
                throw new IllegalArgumentException("Аргумент x должен быть меньше 2 * terms для достаточной точности");
            }

            double sum = 0.0;
            double term = 1.0;

            for (int n = 0; n < terms; n++) {
                if (n > 0) {
                    term *= -x * x / ((2 * n - 1) * (2 * n));
                }
                sum += term;
            }
            return sum;
        }


    public static void main(String[] args) {
        try {
            double x = Math.PI / 3;
            int terms = 10;
            System.out.println("cos(" + x + ") ≈ " + cos(x, terms));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}