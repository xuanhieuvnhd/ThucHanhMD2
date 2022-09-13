package storage;

import model.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static controller.ProductManage.products;

public class ReadData {
    public static ArrayList<Product> readFileProductList() {
        try {
            File file = new File("FileProduct.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Product product = new Product(strings[0], strings[1], Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), strings[4]);
                products.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("");
        }
        return products;
    }
}
