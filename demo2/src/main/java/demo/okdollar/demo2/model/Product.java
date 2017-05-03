package demo.okdollar.demo2.model;

/**
 * Created by DELTA on 5/3/2017.
 */

public class Product {
    private String productName;
    private String productPrice;

    public Product(String productName, String productPrice, String productImageUrl) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImageUrl = productImageUrl;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    private String productImageUrl;
}
