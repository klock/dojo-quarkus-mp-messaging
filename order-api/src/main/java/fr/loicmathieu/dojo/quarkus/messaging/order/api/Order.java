package fr.loicmathieu.dojo.quarkus.messaging.order.api;

public class Order {
    public int nbItem;
    public int totalPrice;
    public String userId;
    public String shippingAddress;

    @Override
    public String toString() {
        return "Order : {" +
                "userId: " + userId + ", " +
                "shippingAddress: " + shippingAddress + ", " +
                "nbItem: " + nbItem + ", " +
                "totalPrice: " + totalPrice + ", " +
                "}";
    }
}
