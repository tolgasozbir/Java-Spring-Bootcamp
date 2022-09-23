package refenceTypes;

public class ValueAndReferenceTypes {
    public static void main(String[] args) {
        //int,decimal,float,enum,boolean - value types (Değer Tip)
        int num1 = 10;
        int num2 = 20;

        num1 = num2;
        num2 = 999;
        System.out.println(num1); //20

        System.out.println("///");

        String city1="Ankara";
        String city2="Istanbul";

        city1=city2;
        city2="Kocaeli";
        System.out.println(city1);  //Istanbul      String = char array

        System.out.println("///");

        //arrays,class,interface,objects... - reference types (Referans Tip)
        int[] array1 = new int[] { 1, 2, 3 };
        int[] array2 = new int[] { 10, 20, 30 };

        array1 = array2;
        array2[0] = 999;

        System.out.println(array1[0]);  //999
    }
}
