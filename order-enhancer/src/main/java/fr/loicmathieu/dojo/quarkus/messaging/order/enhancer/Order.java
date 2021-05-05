package fr.loicmathieu.dojo.quarkus.messaging.order.enhancer;

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
