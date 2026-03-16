package SESSION07.SESSION07_03;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
//        COD
        PaymentMethod codPayment = new CODPayment();
        processor.process(codPayment, 500000);
//        Thẻ tín dụng
        PaymentMethod cardPayment = new CreditCardPayment();
        processor.process(cardPayment, 1000000);
//        Ví MoMo
        PaymentMethod momoPayment = new MomoPayment();
        processor.process(momoPayment, 750000);
    }
}
