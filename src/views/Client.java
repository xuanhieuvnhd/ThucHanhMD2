package views;

import controller.ProductManage;
import storage.ReadData;
import storage.WriteData;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManage productManage = new ProductManage();
        int choice;
        do {
            System.out.println("---- CHUONG TRINH QUAN LY SAN PHAM ----");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them moi");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Sap xep");
            System.out.println("6. Tim san pham co gia cao nhat");
            System.out.println("7. Doc tu file Csv");
            System.out.println("8. Ghi vao file Csv");
            System.out.println("9. Thoat chuong trinh");
            System.out.println("--------------------------------------------------------");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> productManage.displayProduct();
                case 2 -> productManage.addProduct(scanner);
                case 3 -> productManage.editProduct(scanner);
                case 4 -> productManage.productRemove(scanner);
                case 5 -> {
                    int choice1;
                    System.out.println("1. Sap xep tang dan");
                    System.out.println("2. Sap xep giam dan");
                    choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1 -> productManage.sortProductsByPriceAscending();
                        case 2 -> productManage.sortProductByPriceDescending();
                    }
                }
                case 6 -> productManage.searchMaxPrice();
                case 7 -> ReadData.readFileProductList();
                case 8 -> WriteData.writeFileProduct("FileProduct.csv");
                case 9 -> System.exit(0);
            }
        } while (true);
    }
}
