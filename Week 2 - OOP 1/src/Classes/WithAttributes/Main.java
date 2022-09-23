package Classes.WithAttributes;

public class Main {
    public static void main(String[] args) {
        Product product=new Product();
        product.id=1;
        product.name="Asus Laptop";
        product.description="next generation computer";
        product.price=4.999;
        product.stockAmount=14;

        ProductManager productManager=new ProductManager();
        productManager.add(product);
    }
}
