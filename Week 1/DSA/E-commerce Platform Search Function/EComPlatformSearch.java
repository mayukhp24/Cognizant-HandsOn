import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class ProductSearch {

    static int linearSearch(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(Product[] sorted, String name) {
        int low = 0;
        int high = sorted.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sorted[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Footwear"),
            new Product(3, "Watch", "Accessories"),
            new Product(4, "Bag", "Accessories")
        };

        int idx = linearSearch(products, "Watch");
        System.out.println("Linear search found at index: " + idx);

        Product[] sorted = products.clone();
        Arrays.sort(sorted, Comparator.comparing(p -> p.productName.toLowerCase()));

        int bidx = binarySearch(sorted, "Watch");
        System.out.println("Binary search found at index: " + bidx);
    }
}
