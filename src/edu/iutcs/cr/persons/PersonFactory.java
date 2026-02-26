package edu.iutcs.cr.persons;


public class PersonFactory {

    public static Buyer createBuyer(String name, String id, String email, PaymentMethod paymentMethod) {
        return new Buyer(name, id, email, paymentMethod);
    }

    public static Seller createSeller(String name, String id, String email) {
        return new Seller(name, id, email);
    }

}
