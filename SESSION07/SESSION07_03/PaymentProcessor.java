package SESSION07.SESSION07_03;

public class PaymentProcessor {
    public void process(PaymentMethod method, double amount){
        method.processPayment(amount);
    }
}
