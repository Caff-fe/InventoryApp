import java.util.List;

public class Inventory {
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String productName;
    private double weight;
    private double price;

    public Inventory(String productName, double price, double weight) {
         this.productName = productName; this.price = price; this.weight = weight;
    }




    public String toString() {
        return productName + " " + price + " " + weight;
    }




}
