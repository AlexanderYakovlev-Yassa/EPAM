package by.epam.cl_obj.payment.Report;

import by.epam.cl_obj.payment.objects.Payment;

import java.util.Arrays;
import java.util.Collections;


/*Класс выводит информацию о платеже
*       String getReceipt(Payment payment) - печатает чек
*
* */
public class Report {

    public String getReceipt(Payment payment){

        StringBuilder sb = new StringBuilder();
        String[] products = payment.getProducts();
        Arrays.sort(products, Collections.reverseOrder());

        if (payment != null){

            if (payment.isPaid()){
                sb.append("чек № " + payment.getId() + " оплачен\n");
            } else {
                sb.append("\t\tчек № " + payment.getId() + " к оплате\n");
            }

            sb.append(String.format("%20s %6s \n", "товар", "цена"));

            for (String s : products){
                sb.append(s);
            }
            sb.append(String.format("%20s %6.2f руб\n", "общая стоимость", payment.getTotalPrice()));
            sb.append(String.format("%20s %6.2f руб\n", "сумма налога", payment.getTaxAmount()));
            sb.append(String.format("%20s %6.2f руб\n", "сумма к оплате", payment.getAmountPayable()));

        } else {
            sb.append("Такой платеж не существует.");
        }

        return sb.toString();
    }
}
