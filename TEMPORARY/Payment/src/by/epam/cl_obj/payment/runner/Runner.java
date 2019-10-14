package by.epam.cl_obj.payment.runner;

import by.epam.cl_obj.payment.logic.PaymentLogic;
import by.epam.cl_obj.payment.objects.Payment;
import by.epam.cl_obj.payment.objects.Product;

public class Runner {

    public static void main(String[] args) {

        PaymentLogic paymentLogic = new PaymentLogic();

        Payment payment1 = paymentLogic.createPayment();
        Payment payment2 = paymentLogic.createPayment();

        System.out.println(payment1.getId());
        System.out.println(payment2.getId());

        Product[] store = store();

        Product[] basket = new Product[15];

        for (int i = 0; i < basket.length; i++) {

            payment1.addToBasket(store[(int)(Math.random() * 9.99)]);

        }




    }

    private static Product[] store(){

        Product[] products = new Product[10];

        products[0] = new Product("Хлеб \"Майский\"", 0.9);
        products[1] = new Product("Хлеб \"Нарочанский\"", 1.9);
        products[2] = new Product("Хлеб \"Ситный\"", 0.8);
        products[3] = new Product("Хлеб \"Радзивиловский\"", 1.2);
        products[4] = new Product("Молоко \"Минское 0,25 л\"", 0.7);
        products[5] = new Product("Молоко \"Минское 0,5 л\"", 1.3);
        products[6] = new Product("Молоко \"Минское 1,0 л\"", 2.5);
        products[7] = new Product("Молоко \"Рогачевское 1,0л\"", 2.3);
        products[8] = new Product("Кефир \"Минский 0,5 л\"", 0.5);
        products[9] = new Product("Кефир \"Минский 1,0 л\"", 0.95);

        return products;
    }
}
