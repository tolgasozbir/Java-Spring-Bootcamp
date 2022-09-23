package encapsulation;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.setId(1);
        product.setName("Laptop");
        product.setUnitPrice(6999);
        product.setDiscount(7);

        System.out.println(product.getCode());
        System.out.println(product.getUnitPrice());
        
        Product product2 = new Product(2, "Tablet", 3499, 5);

        System.out.println(product2.getCode());
        System.out.println(product2.getUnitPrice());
        
    }
}
