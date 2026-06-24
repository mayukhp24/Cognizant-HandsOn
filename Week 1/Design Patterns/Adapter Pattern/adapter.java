interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Paid Rs." + amount + " through PayPal");
    }
}

class RazorpayGateway {
    public void pay(double rupees) {
        System.out.println("Paid Rs." + rupees + " through Razorpay");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(double amount) {
        gateway.pay(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(1500.0);

        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());
        razorpay.processPayment(2300.0);
    }
}
