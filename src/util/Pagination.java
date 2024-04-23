package util;

public interface Pagination {
    default int pageNavigation(int currentPage, int totalPages) {
        return 0;
    }
}
