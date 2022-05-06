package com.company.interfaces;
public interface ConverterInterface {
        void ConverterIf();
        void ConverterSwitch();
}

//        /**
//         * This method converts the given number into its corresponding month.
//         * @param monthNumber&mdash;the number you wish to convert to a month
//         * @return&mdash;the name of the corresponding month if the parameter value is between 1 and 12; error message otherwise */
//        String convertMonth(int monthNumber);
//        /**
//         * This method converts the given number into its corresponding day of the week.
//         * @param dayNumber&mdash;number you wish to convert to a day of the week
//         * @return&mdash;the name of the corresponding day if the parameter value is between 1 and 7, error message otherwise
//         * The first day of the week is Sunday
//         */
//        String convertDay(int dayNumber);

//        public int readInt(String prompt);
//        public long readLong(String prompt);
//        public double readDouble(String prompt);
//        public float readFloat(String prompt);
//        public String readString(String prompt);

//        static void ConverterIf(int number) {
//                if (number == 1) {
//                        System.out.println("The corresponding month for " + number + " is January.");
//                } else if (number == 2) {
//                        System.out.println("The corresponding month for " + number + " is February.");
//                } else if (number == 3) {
//                        System.out.println("The corresponding month for " + number + " is March.");
//                } else if (number == 4) {
//                        System.out.println("The corresponding month for " + number + " is April.");
//                } else if (number == 5) {
//                        System.out.println("The corresponding month for " + number + " is June.");
//                } else if (number == 7) {
//                        System.out.println("The corresponding month for " + number + " is July.");
//                } else if (number == 8) {
//                        System.out.println("The corresponding month for " + number + " is August.");
//                } else if (number == 9) {
//                        System.out.println("The corresponding month for " + number + " is September.");
//                } else if (number == 10) {
//                        System.out.println("The corresponding month for " + number + " is October.");
//                } else if (number == 11) {
//                        System.out.println("The corresponding month for " + number + " is November.");
//                } else if (number == 12) {
//                        System.out.println("The corresponding month for " + number + " is December.");
//                } else {
//                        System.out.println("Error. Please enter a number between 1 and 12.");
//                }
//        }
//
//        static void ConverterSwitch(int number) {
//                switch (number) {
//                        case 1 -> System.out.println("The corresponding day for " + number + " is Sunday.");
//                        case 2 -> System.out.println("The corresponding day for " + number + " is Monday.");
//                        case 3 -> System.out.println("The corresponding day for " + number + " is Tuesday.");
//                        case 4 -> System.out.println("The corresponding day for " + number + " is Wednesday.");
//                        case 5 -> System.out.println("The corresponding day for " + number + " is Thursday.");
//                        case 6 -> System.out.println("The corresponding day for " + number + " is Friday.");
//                        case 7 -> System.out.println("The corresponding day for " + number + " is Saturday.");
//                        default -> System.out.println("Error. Please enter a number between 1 and 7.");
//                }
//        }