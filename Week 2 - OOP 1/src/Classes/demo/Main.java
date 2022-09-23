package Classes.demo;

public class Main {
    public static void main(String[] args) {

        MathOperations mathOperations=new MathOperations();
        double val1 = mathOperations.addition(5,8);
        double val2 = mathOperations.subtraction(5,8);
        double val3 = mathOperations.multiplication(5,8);
        double val4 = mathOperations.division(10,8);

        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);
        System.out.println(val4);
    }
}
