package by.epam.cl_obj.payment.objects;

import by.epam.cl_obj.payment.utils.ProductUtils;

import java.util.Arrays;
import java.util.Objects;

public class Payment {

    private static double tax;
    private Product[] products;
    private boolean paid;

    //***********************************  inner PRODUCT  *******************************
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return getName().equals(product.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName());
        }
    }
    //***********************************************************************************

    {
        tax = 0.12;
    }

    public Payment() {

        this.products = new Product[0];
        this.paid = false;
    }

    public boolean addProduct(String name, double price) {

        boolean res;
        Product product;
        ProductUtils u = new ProductUtils();

        if (u.isNameValid(name) && u.isPriceValid(price)) {

            try {

                product = new Product(name, price);

                if (isProductExists(product)){
                    product = findProduct(product);
                }
                res = true;

            } catch (Exception e) {

                res = false;

            }

        } else {

            res = false;
        }

        return res;
    }

    private boolean isProductExists(Product product){

        boolean res = false;

        for (Product p : products){
            if (product.equals(p)){
                res = true;
            }
        }

        return res;
    }

    private Product findProduct(Product product){

        for (Product p : products){

            if (product.equals(p)){
                product = p;
            }
        }

        return product;
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

    public Product[] getProducts() {
        return products;
    }

    public int getProductsLength(){//???????????????????????????????????
        return products.length;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public String getProductName(Product product){//???????????????????????????????
        return product.getName();
    }

    public double getTotalPrice() {

        double tPrice = 0;

        for (Product p : products) {
            tPrice += p.getPrice();
        }

        tPrice = tPrice + tPrice * tax;

        return tPrice;
    }
}
