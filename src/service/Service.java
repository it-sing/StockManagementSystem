package service;

import model.Product;

import java.util.List;
import java.util.Scanner;

public interface Service {
    void createProduct(List<Product> productList , String filename);
    void readOnlyProduct(List<Product> productList);
    void randomProduct(List<Product> Transactions , List<Product> productList  ,String filename);
    void editProduct(List<Product> Transactions , String filename);
    void deleteProduct(List<Product> productList , String filename);
    void searchProduct(List<Product> productList);
    void readProductsFromFile(List<Product> productList);
    void writeProductsToFile(List<Product> productList,String filename);
    void viewAllProduct(List<Product> productList);
    void setRowsPerPage(Scanner scanner);
    void commitData(List<Product> Transactions , List<Product> productList  ,String filename);
    void clearData(String fileName);
    void  exitProgram (List<Product> Transactions , List<Product> productList  ,String filename);
    void checkTransactions(List<Product> Transactions , List<Product> productList  ,String filename);
}
