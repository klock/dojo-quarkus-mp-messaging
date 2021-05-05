package fr.loicmathieu.dojo.quarkus.messaging.order.enhancer;

public class EnhancedOrder {
    public int nbItem;
    public int totalPrice;
    public String userId;
    public String shippingAddress;
    public String userFirstName;
    public String userLastName;

    @Override
    public String toString() {
        return "EnhancedOrder : {" +
                "userId: " + userId + ", " +
                "userFirstName: " + userFirstName + ", " +
                "userLastName: " + userLastName + ", " +
                "shippingAddress: " + shippingAddress + ", " +
                "nbItem: " + nbItem + ", " +
                "totalPrice: " + totalPrice + ", " +
                "}";
    }
}
