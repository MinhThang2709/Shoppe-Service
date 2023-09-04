package service;

import entity.CartLineItem;
import entity.Customer;
import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService extends CartService {
    private List<CartLineItem> shoppingCart = new ArrayList<CartLineItem>();

    private CartService cartService = new CartService();

    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Register User");
            System.out.println("2. View Product List");
            System.out.println("3. Add To Cart");
            System.out.println("4. View Shopping Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    viewProductList();
                    break;
                case 3:
                    addToCart();
                    break;
                case 4:
                    viewShoppingCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    public void addToCart() {
        ProductService.createProductList();
        ProductService.printProductList();

        List<CartLineItem> cartItemsToAdd = new ArrayList<>();

        while (true) {
            System.out.print("Enter the product number to add to the cart (0 to finish): ");
            int productNumber = scanner.nextInt();
            scanner.nextLine();

            if (productNumber == 0) {
                break;
            }

            if (productNumber >= 1 && productNumber <= ProductService.products.size()) {
                Product selectedProduct = ProductService.products.get(productNumber - 1);

                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if (quantity > 0) {
                    CartLineItem cartItem = new CartLineItem(selectedProduct, quantity);
                    cartItemsToAdd.add(cartItem);
                    System.out.println("Added " + quantity + " " + selectedProduct.getProductName() + "(s) to the cart.");
                } else {
                    System.out.println("Invalid quantity. Please try again.");
                }
            } else {
                System.out.println("Invalid product number. Please try again.");
            }
        }

        shoppingCart.addAll(cartItemsToAdd);
        System.out.println("Added items to the cart successfully!");
    }

    public void viewShoppingCart() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Your shopping cart contains the following products:");
            for (int i = 0; i < shoppingCart.size(); i++) {
                CartLineItem cartItem = shoppingCart.get(i);
                Product product = cartItem.getProduct();
                int quantity = cartItem.getQuantity();
                System.out.println((i + 1) + ". " + " productName = " + product.getProductName()+ " "+ ", quantity = "+quantity + ", subtotal = "+cartItem.getSubtotal());
            }
        }
    }


    public void registerUser() {
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean isUserNameExists = isUserNameExists(userName);

        if (isUserNameExists) {
            System.out.println("Username already exists. Please choose another username.");
        } else {
            Customer customer = new Customer(userName, password);
            customers.add(customer);
            System.out.println("Registration successful!");
        }
    }

    private boolean isUserNameExists(String userName) {
        for (Customer customer : customers) {
            if (customer.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }



    public void viewProductList() {
        ProductService.createProductList();

        System.out.print("Enter page number: ");
        int page = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter page size: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        List<Product> products = ProductService.getProductsByPageAndSize(page, size);
        System.out.println("List of products on page " + page + " with size " + size + ":");
        for (Product product : products) {
            System.out.println(product);
        }
    }


}
