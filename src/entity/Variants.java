package entity;

public class Variants {
    private int variantId;
    private String size;
    private String color;
    private long variantPrice;


    public Variants(int variantId, String size, String color) {
        this.variantId = variantId;
        this.size = size;
        this.color = color;
    }

    public Variants(int variantId, String size, String color, long variantPrice) {
        this.variantId = variantId;
        this.size = size;
        this.color = color;
        this.variantPrice = variantPrice;
    }

    public long getVariantPrice() {
        return variantPrice;
    }

    public void setVariantPrice(long variantPrice) {
        this.variantPrice = variantPrice;
    }

    public Variants() {
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Variants{" +
                "variantId=" + variantId +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", variantPrice=" + variantPrice +
                '}';
    }
}