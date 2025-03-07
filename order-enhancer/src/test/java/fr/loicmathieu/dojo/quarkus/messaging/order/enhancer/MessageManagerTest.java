package fr.loicmathieu.dojo.quarkus.messaging.order.enhancer;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.connectors.InMemoryConnector;
import io.smallrye.reactive.messaging.connectors.InMemorySink;
import io.smallrye.reactive.messaging.connectors.InMemorySource;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

@QuarkusTest
@QuarkusTestResource(InMemoryChannelTestResource.class)
class MessageManagerTest {

    @Inject
    @Any
    InMemoryConnector connector;

    @Test
    void test() {
        // Retrieves the in-memory source to send message
        InMemorySource<Order> orders = connector.source("orders");
        // Retrieves the in-memory sink to check what is received
        InMemorySink<EnhancedOrder> results = connector.sink("enhanced-orders");

        // Send order
        Order order = new Order();
        order.userId = "user1";
        orders.send(order);

        // Check you have receives the expected messages
        Assertions.assertEquals(1, results.received().size());

        Message<EnhancedOrder> message = results.received().get(0);
        EnhancedOrder payload = message.getPayload();
        Assertions.assertEquals(payload.userId, "user1");
    }
}
