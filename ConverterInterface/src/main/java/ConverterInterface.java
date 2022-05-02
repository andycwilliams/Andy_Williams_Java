public interface ConverterInterface {
    static void ConverterIf(int number) {
        if (number == 1) {
            System.out.println("The corresponding month for " + number + " is January.");
        } else if (number == 2) {
            System.out.println("The corresponding month for " + number + " is February.");
        } else if (number == 3) {
            System.out.println("The corresponding number for " + number + " is March.");
        } else if (number == 4) {
            System.out.println("The corresponding number for " + number + " is April.");
        } else if (number == 5) {
            System.out.println("The corresponding number for " + number + " is June.");
        } else if (number == 7) {
            System.out.println("The corresponding number for " + number + " is July.");
        } else if (number == 8) {
            System.out.println("The corresponding number for " + number + " is August.");
        } else if (number == 9) {
            System.out.println("The corresponding number for " + number + " is September.");
        } else if (number == 10) {
            System.out.println("The corresponding number for " + number + " is October.");
        } else if (number == 11) {
            System.out.println("The corresponding number for " + number + " is November.");
        } else if (number == 12) {
            System.out.println("The corresponding number for " + number + " is December.");
        } else {
            System.out.println("Error. Please enter a number between 1 and 12.");
        }
    }

    static void ConverterSwitch(int number) {
        switch (number) {
            case 1 -> System.out.println("The corresponding day for " + number + " is Sunday.");
            case 2 -> System.out.println("The corresponding day for " + number + " is Monday.");
            case 3 -> System.out.println("The corresponding day for " + number + " is Tuesday.");
            case 4 -> System.out.println("The corresponding day for " + number + " is Wednesday.");
            case 5 -> System.out.println("The corresponding day for " + number + " is Thursday.");
            case 6 -> System.out.println("The corresponding day for " + number + " is Friday.");
            case 7 -> System.out.println("The corresponding day for " + number + " is Saturday.");
            default -> System.out.println("Error. Please enter a number between 1 and 7.");
        }
    }

    static void main(String[] args) {
        ConverterIf(7);
        ConverterSwitch(7);
    }
}
