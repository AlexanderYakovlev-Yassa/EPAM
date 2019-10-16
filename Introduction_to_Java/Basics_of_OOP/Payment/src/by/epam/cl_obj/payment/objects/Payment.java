package by.epam.cl_obj.payment.objects;

import by.epam.cl_obj.payment.utils.ProductUtils;

import java.util.Arrays;
import java.util.Objects;

/*
* Класс представляет платеж.
* поля:
*   private static double tax = 0.12;   - хранит значение налога (коэффициент)
    private static int lastID = 2235;   - хранит ID последнего платежа
    private int id;                     - ID платежа
    private Product[] products;         - массив продуктов включенных в платеж
    private boolean paid;               - статус оплаты
* методы:
*   boolean addProduct(String name, double price) - добавляет товар к платежу. Возвращает статус операции добавления.
*   public String[] getProducts()   - возвращает массив строк содержащих информацию о товарах включенных в платеж.
*   public boolean isPaid()     - возвращает статус оплаты платежа.
*   boolean pay()       - проводит платеж, возвращает статус операции.
*   static double getTax()      - возвращает налоговый коэффициент.
*   double getTotalPrice() - возвращает общую стоимость товаров
*   double getTaxAmount() - возвращает сумму налога на все товары платежа.
*   double getAmountPayable() - возвращает сумму требуемую к оплате.
*   Product findProduct(String name) - ищет товар по наименованию в товарах платежа и возвращает найденный товар.
*
* */
public class Payment {

    private static double tax = 0.12;
    private static int lastID = 2235;
    private int id;
    private Product[] products;
    private boolean paid;


    /*
    * Класс представляет товар
    * поля:
    *   private String name       - наименование товара
    *   private double price      - стоимость товара
    *
    * */
    private class Product {
        private String name;
        private double price;

        public Product() {
            this.name = "no_name";
            this.price = 0;
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public Payment() {

        this.products = new Product[0];
        this.paid = false;
        this.id = ++lastID;
    }

    public boolean addProduct(String name, double price) {

        boolean res;
        Product product;
        ProductUtils u = new ProductUtils();

        if (u.isNameValid(name)) {

            product = findProduct(name);

            if (product == null) {

                if (u.isPriceValid(price)){
                    product = new Product(name, price);
                } else {
                    product = new Product(name, 0.0);
                }
            }

            products = Arrays.copyOf(products, products.length + 1);
            products[products.length - 1] = product;
            res = true;

        } else {

            res = false;
        }

        return res;
    }

    public String[] getProducts(){

        String[] productStrings = new String[products.length];

        for (int i = 0; i < products.length; i++) {

            productStrings[i] = String.format("%20s %6.2f руб\n", products[i].getName(), products[i].getPrice());
        }

        return productStrings;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean pay() {
        boolean res;
        if (isPaid()){
            res = false;
        } else {
            this.paid = true;
            res = true;
        }
        return  res;
    }

    public static double getTax() {
        return tax;
    }

    public int getId() {
        return id;
    }

    public double getTotalPrice() {

        double tPrice = 0;

        for (Product p : products) {
            tPrice += p.getPrice();
        }

        return tPrice;
    }

    public double getTaxAmount() {

        double taxAmount = 0;

        taxAmount = getTotalPrice() * tax;

        return taxAmount;
    }


    public double getAmountPayable() {

        double amountPayable = 0;

        amountPayable = getTotalPrice() + getTaxAmount();

        return amountPayable;
    }

    private Product findProduct(String name) {

        Product product = null;

        for (Product p : products) {

            if (p.getName().equals(name)) {
                product = p;
                break;
            }
        }

        return product;
    }
}
