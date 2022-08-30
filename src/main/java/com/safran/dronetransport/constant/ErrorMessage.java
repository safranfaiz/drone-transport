package com.safran.dronetransport.constant;

public class ErrorMessage {

    public static class Drone {
        public static final String DRONE_WEIGHT_ERROR = "Your drone weight capacity is not in range";
        public static final String DRONE_BATTERY_LOW_ERROR = "Drone Battery is low ";
        public static final String DRONE_NOT_LOADABLE ="Drone is not in loadable state";
        public static final String DRONE_NOT_FOUND = "Cannot find Drone by this serial number: ";
    }

    public static class Medication {
        public static final String MEDICATION_NOT_FOUND = "Cannot find medication by this code: ";
    }
}
