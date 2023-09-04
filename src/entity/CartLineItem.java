package entity;

import service.CustomerService;
import service.ProductService;

import java.util.List;

public class CartLineItem {
    private Product product;
    private int quantity;
    private long subtotal ;

    public CartLineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.subtotal = quantity * product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }
}
