package service;


import entity.CartLineItem;
import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartService {
    private List<CartLineItem> cartLineItems = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void placeOrder() {

        cartLineItems.clear();
        System.out.println("Order placed successfully!");
    }
}
