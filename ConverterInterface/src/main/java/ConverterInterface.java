public interface ConverterInterface {
    static void ConverterIf(int number) {
        System.out.println("TEST COMPLETE! " + number);
//        return 6;
    }

    public static void main(String[] args) {
        ConverterIf(7);
//        System.out.println("Placeholder. PLACE + HELD.");
    }
//    static void ConverterIf(monthNumber) {
//        int monthNo = 7;
////        if(){} else if () {} else {}
//        // monthNumber
//        // return monthName
//        System.out.println(monthNo);
//    }
}

    /**
     * This method converts the given number into its corresponding month.
     * @param monthNumber&mdash;the number you wish to convert to a month
     * @return&mdash;the name of the corresponding month if the parameter value is between 1 and 12; error message otherwise
     * */
//    String convertMonth(int monthNumber);

    /**
     * This method converts the given number into its corresponding day of the week.
     * @param dayNumber&mdash;number you wish to convert to a day of the week
     * @return&mdash;the name of the corresponding day if the parameter value is between 1 and 7, error message otherwise
     * The first day of the week is Sunday
     */
//    String convertDay(int dayNumber);

//    1. Create your solution in an IntelliJ project called ConverterInterface .
//    2. Create two implementations of the following interface.
//    3. The first implementation must use "if"/"else if"/"else" statements and be called ConverterIf .
//    4. The second implementation must use switch statements and be called ConverterSwitch .
//    5. Create a class called ConverterApplication , which has your main method.
//    6. Instantiate and use both the ConverterIf and ConverterSwitch classes in that main method.
//    7. Implement the interface of ConverterIf and ConverterSwitch classes by using the following code:

//public interface Converter {
//    /**
//     * This method converts the given number into its corresponding month.
//     * @param monthNumber&mdash;the number you wish to convert to a month
//     * @return&mdash;the name of the corresponding month if the parameter value is between 1 and 12; error message otherwi */
//    String convertMonth(int monthNumber);
//    /**
//     * This method converts the given number into its corresponding day of the week.
//     * @param dayNumber&mdash;number you wish to convert to a day of the week
//     * @return&mdash;the name of the corresponding day if the parameter value is between 1 and 7, error message otherwise
//     * The first day of the week is Sunday
//     */
//    String convertDay(int dayNumber);
//}

// ====================================================

// Implementation:
//    class ArrayFun {
//    public int[] computeAverages(int[][] input) {  // {{1, 2, 3}, {4, 5, 6}, {7, 8}}
//        int[] returnVal = new int[input.length];    // returnVal = { , , }
//        for (int i = 0; i < input.length; i++) {
//            int sum = 0;
//            for (int x : input[i]) {  // {1, 2, 3}
//                if (x < 0) {
//                    throw new IllegalArgumentException("No values may be negative.");
//                }
//                sum += x;
//            }
//            if (input[i].length == 0) {
//                returnVal[i] = 0;
//            } else {
//                returnVal[i] = sum / input[i].length;
//            }
//        }