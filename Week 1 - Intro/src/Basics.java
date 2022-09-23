public class Basics {
    public static void main(String[] args) {
        dataTypes();
        conditionals();
        loops();
        switchCase();
    }
    
    public static void dataTypes() {
        int number = 55;
        int credit = 10000;
        double average = 12.5;
        String firstName = "Tolga";
        char character = 'S';
        boolean isLoggedIn = false;

        System.out.println("number is : " + number);
        System.out.println(credit);
        System.out.println(average);
        System.out.println("Name : " + firstName);
        System.out.println(character);
        System.out.println("is the user logged in? : " + isLoggedIn);
    }

    private static void conditionals() {
        int value = 32;

        if (value >= 55 && value <= 100) {
            System.out.println("successful");
        } else if (value < 55)
            System.out.println("unsuccessful");
        else {
            System.out.println("invalid value");
        }
    }

    private static void loops() {
        System.out.println("\n********** for **********");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.println("\n********** while **********");
        int num = 10;
        while (num <= 100) {
            System.out.println(num);
            num += 10;
        }

        System.out.println("\n**********  do while **********\n");
        int num2 = 1;
        do {
            System.out.println(num2);
            num2++;
        } while (num2 > 2);
    }

    private static void switchCase() {
        char grade = 'A';

        switch (grade) {
            case 'A':
            case 'B':
                System.out.println("Good, You Passed");
                break;
            case 'C':
            case 'D':
                System.out.println("You Passed");
                break;
            case 'F':
                System.out.println("Unfortunately, You Have Failed");
                break;
            default:
                System.out.println("Invalid value");
        }
    }
}
