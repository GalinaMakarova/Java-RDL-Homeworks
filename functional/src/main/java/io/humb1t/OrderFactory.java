package io.humb1t;

import static io.humb1t.Main.Order;
import static io.humb1t.Main.OrderStatus.*;

public interface OrderFactory {
    default Order notStartedOrder() {
        return new Order(NOT_STARTED);
    }

    default Order processingOrder() {
        return new Order(PROCESSING);
    }

    default Order completedOrder() {
        return new Order(COMPLETED);
    }
}
