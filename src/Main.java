import entity.CartLineItem;
import entity.Customer;
import entity.Product;
import entity.Seller;
import service.*;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
//    ProductService.createProductList();
//    ProductService.printProductList();
//
//        ProductService.getProductsByPageAndSizeFromUserInput();
//        ProductService.getProductsByPageAndSize(10,100);

        CustomerService customerService = new CustomerService();
        customerService.run();


    }
}
