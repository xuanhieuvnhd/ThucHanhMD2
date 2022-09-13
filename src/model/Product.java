package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Product implements Comparable<Product> {
    private String productCode;
    private String productName;
    private int productPrice;
    private int productAmount;
    private String productDescribe;

    public Product(String productCode, String productName, int productPrice, int productAmount, String productDescribe) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productDescribe = productDescribe;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        return "San Pham{" +
                "Ma san pham: '" + productCode + '\'' +
                ", Ten: '" + productName + '\'' +
                ", Gia: " + numberFormat.format(productPrice) + "VND"+
                ", So luong: " + productAmount +
                ", Mo ta: '" + productDescribe + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product a) {
        return this.getProductPrice() - a.getProductPrice();

    }
}