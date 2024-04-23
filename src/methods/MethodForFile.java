package methods;

import model.Product;

public interface MethodForFile {
    void updateProductInFile(Product product);
    void restoreData(String sourceFilePath, String backupDirectory, int fileNumber);
    void listBackupFiles(String backupDirectory);
    void backUpData();

}
