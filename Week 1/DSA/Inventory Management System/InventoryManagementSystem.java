import java.util.HashMap;
import java.util.Map;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + " | " + productName + " | qty=" + quantity + " | Rs." + price;
    }
}

public class InventoryManagementSystem {
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        if (inventory.containsKey(p.productId)) {
            System.out.println("Product already exists: " + p.productId);
            return;
        }
        inventory.put(p.productId, p);
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product p = inventory.get(productId);
        if (p == null) {
            System.out.println("No product found with id " + productId);
            return;
        }
        p.quantity = quantity;
        p.price = price;
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) == null) {
            System.out.println("Nothing to delete for id " + productId);
        }
    }

    public void printAll() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem system = new InventoryManagementSystem();
        system.addProduct(new Product(101, "Keyboard", 50, 799.0));
        system.addProduct(new Product(102, "Mouse", 120, 399.0));
        system.addProduct(new Product(103, "Monitor", 30, 8999.0));

        system.updateProduct(102, 100, 449.0);
        system.deleteProduct(101);

        system.printAll();
    }
}
