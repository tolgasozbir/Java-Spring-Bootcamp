package methods;

public class Methods2 {
    public static void main(String[] args) {
        int add1 = addition1(1,2,3,4,5,6,7,8,9);
        System.out.println(add1);
        
        int[] numbers = {1,2,3,4,5};
        int add2 = addition1(numbers);
        System.out.println(add2);
    }

    public static int addition1(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }

        return  total;
    }

    public static int addition2(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }

        return  total;
    }
}
