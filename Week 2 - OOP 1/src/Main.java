public class Main {
    public static void main(String[] args) throws Exception {

        Product product1 = new Product();
        product1.setName("Delonghi Kahve Makinesi");
        product1.setUnitPrice(7500);
        product1.setDiscount(7);
        product1.setUnitsInStock(3);
        product1.setImageUrl("dlg.jpg");

        Product product2 = new Product();
        product2.setName("Smeg Kahve Makinesi");
        product2.setUnitPrice(6000);
        product2.setDiscount(5);
        product2.setUnitsInStock(5);
        product2.setImageUrl("smg.jpg");
        
        Product product3 = new Product();
        product3.setName("Kitchen Kahve Makinesi");
        product3.setUnitPrice(5000);
        product3.setDiscount(5);
        product3.setUnitsInStock(12);
        product3.setImageUrl("ktn.jpg");

        Product[] products = {
            product1,
            product2,
            product3,
        };

        System.out.println("<ul>");
        for (Product product : products) {
            System.out.println("<li>" + product.getName() + "</li>");
        }
        System.out.println("</ul>");


        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        individualCustomer.setCustomerNumber("54321");
        individualCustomer.setPhone("05432100000");
        individualCustomer.setFirstName("Tolga");
        individualCustomer.setLastName("Sozbir");

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(2);
        corporateCustomer.setCustomerNumber("12345");
        corporateCustomer.setPhone("05431230000");
        corporateCustomer.setCompanyName("Kodlama.io");
        corporateCustomer.setTaxNumber("1234567890");

        Customer[] customers = {
            individualCustomer, 
            corporateCustomer,
        };

        for (Customer customer : customers) {
            System.out.println(customer.getPhone());
        }

    }
}
