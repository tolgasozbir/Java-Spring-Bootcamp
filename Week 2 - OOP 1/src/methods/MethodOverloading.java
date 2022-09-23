package methods;

public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println(addition(1,2));
        System.out.println(addition(1,2,3));
        System.out.println(addition(1,2,3,4,5,6,7,8,9));
    }

    public static int addition(int num1,int num2){
        return num1+num2;
    }

    public static int addition(int num1,int num2,int num3){
        return num1+num2+num3;
    }

    public static int addition(int... numbers){
        int total=0;
        for (int num:numbers) {
            total+=num;
        }
        return  total;
    }
}
