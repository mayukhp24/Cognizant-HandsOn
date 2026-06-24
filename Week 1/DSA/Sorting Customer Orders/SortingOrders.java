class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return orderId + " | " + customerName + " | Rs." + totalPrice;
    }
}

public class OrderSorting {

    static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int p = partition(orders, low, high);
            quickSort(orders, low, p - 1);
            quickSort(orders, p + 1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Mayukh", 2500.0),
            new Order(2, "Aditi", 1200.0),
            new Order(3, "Rohan", 7800.0),
            new Order(4, "Sneha", 450.0)
        };

        Order[] copyForBubble = orders.clone();
        bubbleSort(copyForBubble);
        System.out.println("After Bubble Sort:");
        for (Order o : copyForBubble) System.out.println(o);

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nAfter Quick Sort:");
        for (Order o : orders) System.out.println(o);
    }
}
