package org.yuliandr.learnJava.util;

public class Validation {

    public static boolean stringValidate(String value) {
            return !(value == null || value.isBlank() || value.isEmpty());
    }

    public static boolean numberValidate(int minVal, int maxVal, int num) {
            return  !(num < minVal || num > maxVal);
    }
}
