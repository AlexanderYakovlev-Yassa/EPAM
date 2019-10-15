package by.epam.cl_obj.payment.logic;

import by.epam.cl_obj.payment.objects.Payment;

public class PaymentLogic {

    public Payment createPayment() {

        Payment payment = new Payment();

        return payment;
    }

   /* public boolean addProductToPayment(Payment payment, String name, double price, int quantity){

        boolean res;
        PaymentUtils u = new PaymentUtils();



        if (u.isNameValid(name) && u.isPriceValid(price)) {


            payment.addProduct(name, price);

            payment.getProducts() = Arrays.copyOf(payment.getProducts(), payment.getProductsLength() + 1);
            payment.getProducts()[payment.getProductsLength() - 1] = product;

            res = true;

        } else {
            res = false;
        }

        return  res;
    }*/

   public void crPr(Payment payment){
       payment.addProduct("ddd", 1.25);
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
