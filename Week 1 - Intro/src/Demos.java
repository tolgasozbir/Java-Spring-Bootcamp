public class Demos {
    public static void main(String[] args) {
        arrayDemo();
        searchNumber();
    }

    public static void arrayDemo() {
        double[] myList = {1.2, 6.5, 4.3, 5.6};
        double total=0;
        double max=myList[0];
        for (double number:myList) {
            if (max<number){
                max=number;
            }
            total+=number;
            System.out.println(number);
        }

        System.out.println("Total : " + total);
        System.out.println("Max Num : " + max);
    }

    public static void searchNumber() {
        int[] numbers = {1,2,3,4,5};
        int searchValue = 3;
        boolean searchStatus = false;

        for (int num : numbers) {
            if (num == searchValue) {
                searchStatus = true;
                break;
            }
        }

        if (searchStatus) {
            System.out.println("number is on the list");
        } else {
            System.out.println("number not listed");
        }
    }

}
