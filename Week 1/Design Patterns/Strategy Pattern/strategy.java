interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String name;

    public CreditCardPayment(String name) {
        this.name = name;
    }

    public void pay(double amount) {
        System.out.println(name + " paid Rs." + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal (" + email + ")");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(double amount) {
        strategy.pay(amount);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment("Mayukh"));
        context.checkout(2500.0);

        context.setStrategy(new PayPalPayment("mayukh@example.com"));
        context.checkout(999.0);
    }
}
