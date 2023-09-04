package entity;

import entity.CartLineItem;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static  List<CartLineItem> cart = new ArrayList<>();
    private int cartId;
    private long totalPrice;

    public static List<CartLineItem> getCart() {
        return cart;
    }

    public Cart() {
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public static List<CartLineItem> getCartitems() {
        return cart;
    }

    public static void setCartitems(List<CartLineItem> cartitems) {
        Cart.cart = cartitems;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", totalPrice=" + totalPrice +
                '}';
    }
}