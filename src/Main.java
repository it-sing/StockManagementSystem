import methods.MethodForFile;
import methods.MethodForFileImpl;
import model.Product;
import service.Service;
import service.ServiceImpl;
import view.Menu;
import view.MenuImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String backupDirectory = "backup/";
    static Service service = new ServiceImpl();
    static MethodForFile method = new MethodForFileImpl();
    static Menu menuDisplay = new MenuImpl();
    static List<Product> productList = new ArrayList<>();
    static List<Product> transactions = new ArrayList<Product>();

    public static void main(String[] args) {
        System.out.println("Welcome to Stock Management System");
        menuDisplay.displayStyle();
        service.checkTransactions(transactions,productList,"transaction.txt");
        service.readProductsFromFile(productList);
        do {
             menuDisplay.displayMenu();
            // add Option Input
            Scanner scanner = new Scanner(System.in);
            System.out.print("> Select menu no -> ");
            String option = scanner.nextLine();
            switch (option) {
                case "l", "L" ->
                    // display code
                    service.viewAllProduct(productList);
                case "m","M"->
                    //random code
                    service.randomProduct(transactions,productList,"transaction.txt");
                case "w", "W" ->
                    // write code
                    service.createProduct(productList,"transaction.txt");
                case "r", "R" ->
                    // read code
                    service.readOnlyProduct(productList);
                case "e", "E" ->
                    // edit code
                   service.editProduct(productList,"transaction.txt");
                case "d", "D" ->
                    // delete code
                   service.deleteProduct(productList,"product.txt");
                case "s", "S" ->
                    // search code
                    service.searchProduct(productList);
                case "o", "O" ->
                    // set row code
                    service.setRowsPerPage(scanner);
                case "c", "C" ->
                    // commit code
                    service.commitData(transactions,productList,"product.txt");
                case "k", "K" ->
                    method.backUpData();
                case "t", "T" ->
                    // restore code
                   method.listBackupFiles(backupDirectory);
                case "h", "H" -> {
                    System.out.println();
                    System.out.println("# Help Instruction");
                    menuDisplay.displayHelpTable();
                }
                case "x", "X" ->
                    service.exitProgram(transactions,productList,"transaction.txt");
                default ->
                    // default code
                    System.out.println("Invalid input");
            }
        } while (true);
    }
}