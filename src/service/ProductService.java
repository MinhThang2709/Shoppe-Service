package service;


import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ProductService {
    protected static List<Product> products = new ArrayList<>();
    private static int productNumber = 0;
    private static int productId = 1;
    private static Scanner scanner = new Scanner(System.in);


    public static void createProductList(){
        for (int index = 1; index < 100; index++) {
            addOneProduct();
        }
    }
    public static void  printProductList(){
        for (int index = 0; index < products.size(); index++) {
            System.out.println(products.get(index));
        }
    }
    private static void addOneProduct() {
        int productId = setProductId();
        String productName = addProductName();
        long productPrice = setPrice();

        Product product = new Product(productId,productName,productPrice);
        products.add(product);

    }
    public static   List<Product> getProductsByPageAndSizeFromUserInput() {

        System.out.print("Nhập trang: ");
        int page = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập kích thước trang: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        List<Product> result = getProductsByPageAndSize(page, size);
        for (Product product: result){
            System.out.println(product);
        }


        return result;

    }
    public static List<Product> getProductsByPageAndSize(int page, int size) {
        List<Product> result = new ArrayList<>();
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, products.size());

        for (int index = startIndex; index < endIndex; index++) {
            result.add(products.get(index));
        }

        return result;
    }

    private static long setPrice() {
        return ThreadLocalRandom.current().nextLong(10,10000);
    }

    private static String addProductName() {
        productNumber++;
        return "Product" + productNumber;
    }

    private static int setProductId() {
        return productId++;
    }


}
