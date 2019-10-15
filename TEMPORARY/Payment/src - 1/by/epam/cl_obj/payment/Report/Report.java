package by.epam.cl_obj.payment.Report;

import by.epam.cl_obj.payment.objects.Payment;

public class Report {

    public String getReceipt(Payment payment){

        StringBuilder sb = new StringBuilder();

        if (payment != null){
            sb.append("***********\n");
            sb.append("");
        } else {
            sb.append("Такой платеж не существует.");
        }

        return sb.toString();
    }
}
