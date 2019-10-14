package by.epam.cl_obj.payment.logic;

import by.epam.cl_obj.payment.objects.Payment;
import by.epam.cl_obj.payment.objects.Product;

public class PaymentLogic {

    public Payment createPayment() {

        Payment payment = new Payment();

        return payment;
    }

    public boolean pay(Payment payment){
        boolean res;
        if (payment != null || payment.getTotalPrice() != 0) {
            if (payment.isPaid()) {
                res = false;
            } else {
                payment.setPaid(true);
                res = true;
            }
        } else {
            res = false;
        }

        return res;
    }

}
