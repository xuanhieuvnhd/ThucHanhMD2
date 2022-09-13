package controller;

import model.Product;
import storage.WriteData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManage {
   public static ArrayList<Product> products = new ArrayList<>();

    public Product creatProduct(Scanner scanner) {
        System.out.println("Nhap ma san pham: ");
        String productCode = scanner.nextLine();
        System.out.println("Nhap ten san pham: ");
        String productName = scanner.nextLine();
        System.out.println("Nhap gia san pham: ");
        int productPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap so luong san pham: ");
        int productAmount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap mo ta san pham: ");
        String productDescribe = scanner.nextLine();
        return new Product(productCode, productName, productPrice, productAmount, productDescribe);
    }

    public void addProduct(Scanner scanner) {
        Product product = creatProduct(scanner);
        products.add(product);
    }

    public void displayProduct() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void editProduct(Scanner scanner) {
        System.out.println("Nhap ma san pham can sua: ");
        String code = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductCode().equals(code)) {
                System.out.println("Nhap ma san pham moi:  ");
                String productCode = scanner.nextLine();
                System.out.println("Nhap ten: ");
                String productName = scanner.nextLine();
                System.out.println("Nhap gia: ");
                int productPrice = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhap so luong: ");
                int productAmount = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhap mo ta: ");
                String productDescribe = scanner.nextLine();
                products.get(i).setProductCode(productCode);
                products.get(i).setProductName(productName);
                products.get(i).setProductPrice(productPrice);
                products.get(i).setProductAmount(productAmount);
                products.get(i).setProductDescribe(productDescribe);
                System.out.println("Sua san pham thanh cong!");
            } else {
                System.out.println("Khong tim thay san pham! ");
            }
        }
    }

    public void productRemove(Scanner scanner) {
        boolean check = false;
        System.out.print("Nhap ma san pham can xoa: ");
        String code = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductCode().equals(code)) {
                products.remove(i);
                System.out.println("Xoa san pham thanh cong !");
                check = true;
            }
        }
        if (!check) {
            System.err.println("Khong tim thay san pham ! " + code);
        }
    }
    public void sortProductsByPriceAscending() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getProductPrice()) - o2.getProductPrice();
            }
        };
        products.sort(comparator);
        System.out.println("Danh sach san pham da duoc xep theo gia tang dan: ");
        displayProduct();
    }
    public void sortProductByPriceDescending() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getProductPrice()) - o1.getProductPrice();
            }
        };
        products.sort(comparator);
        System.out.println("Danh sach san pham da duoc xep theo gia giam dan: ");
        displayProduct();
    }
    public void searchMaxPrice() {
        double max = 0;
        int product = 0;
        for (int i = 0; i < products.size(); i++) {
            if (max < products.get(i).getProductPrice()) {
                max = products.get(i).getProductPrice();
                product = i;
            }
        }
        System.out.println("San pham co gia cao nhat trong he thong la: ");
        System.out.println(products.get(product));
    }
}