package by.epam.cl_obj.payment.objects;

import java.util.Arrays;

public class Payment {

    private static int lastID;
    private static double tax;
    private Basket basket;
    private boolean paid;

    private int id;


   //***********************************  inner BASKET  *******************************
    private class Basket {
        private Product[] products;

        public Basket() {
            this.products = new Product[0];
        }

        /*public void add(Product product) {
            products = Arrays.copyOf(products, products.length + 1);
            products[products.length - 1] = product;
        }*/

       public void setProducts(Product[] products) {
           this.products = products;
       }

       public Product[] getProducts() {
            return products;
        }
    }
    //*********************************************************************************

    {
        tax = 0.12;
        //lastID = 0;
    }

    public Payment(){
        this.id = ++lastID;
        this.basket = new Basket();
        this.paid = false;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public static double getTax() {
        return tax;
    }

    public Basket getBasket() {
        return basket;
    }

    /*public void setBasket(Basket basket) {
        this.basket = basket;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getLastID() {
        return lastID;
    }

    public double getTotalPrice(){

        double tPrice = 0;

        for (Product p : basket.getProducts()){
            tPrice += p.getPrice();
        }

        tPrice = tPrice + tPrice * tax;

        return tPrice;
    }

    public void addToBasket(Product product){

        if (product != null) {
            basket.products = Arrays.copyOf(basket.products, basket.products.length + 1);
            basket.products[basket.products.length - 1] = product;
        }
    }
}
