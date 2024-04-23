package util;

import java.util.Scanner;

import static java.lang.System.out;

public class PaginationImpl implements Pagination{
    @Override
    public int pageNavigation(int currentPage, int totalPages) {
        out.printf("Page Navigation   %-25s (F)irst   (P)revious (G)oto (N)ext  (L)ast%n", "", "", "", "", "");
        out.println("~".repeat(87));
        out.print("(B)ack or Navigation page : ");

        Scanner scanner = new Scanner(System.in);
        char option = scanner.next().charAt(0);
        switch (option) {
            case 'F', 'f':
                return 1;
            case 'P', 'p':
                return Math.max(1, currentPage - 1);
            case 'G', 'g':
                out.print("Enter page number to go to: ");
                int pageNumber = scanner.nextInt();
                return Math.min(Math.max(1, pageNumber), totalPages);
            case 'N', 'n':
                return Math.min(totalPages, currentPage + 1);
            case 'L', 'l':
                return totalPages;
            case 'B', 'b':
                return -1; // Signal to exit loop
            default:
                out.println("Invalid option!");
                return currentPage;
        }
    }
}
