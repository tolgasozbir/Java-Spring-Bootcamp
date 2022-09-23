package encapsulation;

public class Product {
    private int id;
    private String name;
    private double unitPrice;
    private double discount;
    private String code;

    public Product(int id, String name, double unitPrice, double discount) {
        super(); //Base Constructor
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public Product(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        this.unitPrice = this.unitPrice * (100 - getDiscount()) / 100;
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount <= 0) {
            this.discount = 0;
            return;
        }
        this.discount = discount;
    }

    public String getCode() {
        this.code = this.name.substring(0, 1) + this.id;
        return this.code;
    }

}
