package fr.loicmathieu.dojo.quarkus.messaging.search;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MessageManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageManager.class);

    @Inject
    EnhancedOrderService enhancedOrderService;

    @Incoming("enhanced-orders")
    public void readEnhancedOrders(final EnhancedOrder enhancedOrder) {
        LOGGER.info("Saving enhancedOrder: {}", enhancedOrder);
        enhancedOrderService.add(enhancedOrder);
    }
}
