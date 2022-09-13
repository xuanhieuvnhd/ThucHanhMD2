package storage;

import model.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static controller.ProductManage.products;

public class WriteData {
    public static void writeFileProduct(String File) {
        try {
            java.io.File file = new File("FileProduct.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Product product : products) {
                bufferedWriter.write(product.getProductCode() + "," + product.getProductName() + "," + product.getProductPrice() + "," + product.getProductAmount() + "," + product.getProductDescribe() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("");
        }
    }
}
