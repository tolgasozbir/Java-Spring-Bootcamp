package methods;

public class Methods1 {
    public static void main(String[] args) {
        add();
        delete();
        update();

        int number = addition(5,7);
        System.out.println(number);

        String city = getCity();
        System.out.println(city);
    }

    public static void add(){
        System.out.println("Added");
    }

    public static void delete(){
        System.out.println("Deleted");
    }

    public static void update(){
        System.out.println("Updated");
    }

    public static int addition(int num1,int num2){
        return num1+num2;
    }

    public static String getCity(){
        return "Kocaeli";
    }
}
