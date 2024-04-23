package methods;

import model.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.*;

public class MethodForFileImpl implements MethodForFile {
    static final Scanner scanner = new Scanner(in);

    @Override
    public void backUpData() {
       String backupDirectory = "backup/";
        // back up code
        String sourceFilePaths = "product.txt";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        String backupFileName = "backupfile_" + timestamp + ".csv";
        String backupFilePath = backupDirectory + backupFileName;

        System.out.print("Are you sure to Backup [Y/N]: ");
        String ch = scanner.nextLine();

        if (ch.equalsIgnoreCase("y")) {
           backUpImpl(sourceFilePaths, backupFilePath);
        }
    }
    public void backUpImpl(String sourceFilePath, String backupFilePath){
        try {
            Path sourcePath = Path.of(sourceFilePath);
            Path backupPath = Path.of(backupFilePath);
            if (Files.exists(sourcePath)) {
                // Create the backup directory if it doesn't exist
                Files.createDirectories(backupPath.getParent());

                // Open streams with buffering
                try (BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(sourcePath));
                     BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(backupPath))) {

                    // Copy data in chunks
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    outputStream.flush(); // Flush the buffer after writing all data
                }

                System.out.println("Backup created successfully.");
            } else {
                System.out.println("Source file does not exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static File[] getBackupFiles(String backupDirectory) {
        File backupDir = new File(backupDirectory);
        return backupDir.listFiles();
    }
    @Override
    public void listBackupFiles(String backupDirectory) {
        try{
            File backupDir = new File(backupDirectory);
            File[] backupFiles = backupDir.listFiles();
            if (backupFiles != null && backupFiles.length > 0) {
                Table table = new Table(1, BorderStyle.UNICODE_DOUBLE_BOX_WIDE, ShownBorders.SURROUND);
                table.addCell("Backup Files:");

                for (int i = 0; i < backupFiles.length; i++) {
                    table.addCell((i + 1) + ". " + backupFiles[i].getName());
                }
                System.out.println(table.render());
                System.out.print("Enter the number of the backup file to restore: ");
                int fileNumber = scanner.nextInt();
                scanner.nextLine(); // Consume the remaining newline character
                restoreData("product.txt", backupDirectory, fileNumber);
            } else {
                System.out.println("No backup files found.");
            }
        }catch (Exception e){
            out.println(e.getMessage());
        }

    }
    @Override
    public void restoreData(String sourceFilePath, String backupDirectory, int fileNumber) {
        try {
            File[] backupFiles = getBackupFiles(backupDirectory);

            if (fileNumber >= 1 && fileNumber <= backupFiles.length) {
                File selectedFile = backupFiles[fileNumber - 1];
                String backupFileName = selectedFile.getName();
                String directry="restoredfile/";
                String restoredFilePath = sourceFilePath.replaceFirst("[.][^.]+$", "_restored" + backupFileName.substring(backupFileName.lastIndexOf(".")));
                String fullPath= directry+restoredFilePath;
                Files.copy(selectedFile.toPath(), Path.of(fullPath), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Data restored successfully to: " + restoredFilePath);
            } else {
                System.out.println("Invalid file number.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateProductInFile(Product product) {
        List<String> fileContent;
        try {
            // Read all lines from the file
            fileContent = Files.readAllLines(Paths.get("product.txt"));

            // Iterate through the lines and find the line to update
            for (int i = 0; i < fileContent.size(); i++) {
                String line = fileContent.get(i);
                String[] parts = line.split(",");
                if (parts[0].equals(product.getCode())) {
                    // Update the line with the new product details
                    fileContent.set(i, product.getCode() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity() + "," + product.getDate());
                    break;
                }
            }

            // Write the updated content back to the file
            Files.write(Paths.get("product.txt"), fileContent);
        } catch (IOException e) {
            System.out.println("Error updating product in file: " + e.getMessage());
        }
    }



}
