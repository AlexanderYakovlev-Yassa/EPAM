package by.epam.cl_obj.payment.runner;

import by.epam.cl_obj.payment.Report.Report;
import by.epam.cl_obj.payment.objects.Payment;

public class Runner {

    public static void main(String[] args) {

        //создаем платеж
        Payment payment1 = new Payment();

        //набираем корзину продуктов
        payment1.addProduct("Молоко", 1.2);
        payment1.addProduct("Хлеб", 0.9);
        payment1.addProduct("Сметана", 2.2);
        payment1.addProduct("Сметана", 2.0);
        payment1.addProduct("Кефир", 1.1);
        payment1.addProduct("Салат", 3.5);
        payment1.addProduct("Сметана", 2.2);

        //печатаем чек в консоль
        System.out.println("");
        Report r = new Report();
        System.out.println(r.getReceipt(payment1));

        //отмечаем платеж как оплаченый
        payment1.pay();

        //печатаем чек в консоль
        System.out.println(r.getReceipt(payment1));
    }
}
