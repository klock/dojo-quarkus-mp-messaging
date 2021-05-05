package fr.loicmathieu.dojo.quarkus.messaging.order.enhancer;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MessageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageManager.class);

    @Inject
    UserService userService;

    @Incoming("orders")
    @Outgoing("enhanced-orders")
    public EnhancedOrder mapOrderToEnhancedOrder(final Order order) {
        LOGGER.info("Receiving order: {}", order);

        EnhancedOrder enhancedOrder = new EnhancedOrder();
        enhancedOrder.nbItem = order.nbItem;
        enhancedOrder.totalPrice = order.totalPrice;
        enhancedOrder.shippingAddress = order.shippingAddress;

        String userId = order.userId;
        User user = userService.getUser(userId);
        enhancedOrder.userId = user.userId;
        enhancedOrder.userFirstName = user.firstName;
        enhancedOrder.userLastName = user.lastName;
        LOGGER.info("Creating enhanced order: {}", order);

        return enhancedOrder;
    }
}
