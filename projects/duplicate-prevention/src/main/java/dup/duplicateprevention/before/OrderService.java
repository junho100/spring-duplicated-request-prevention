package dup.duplicateprevention.before;

import dup.duplicateprevention.core.Database;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private Database database;

    public OrderService(Database database) {
        this.database = database;
    }

    public void addOrder(String orderId, Long amount) {
        database.add(orderId, amount);
    }

    public Long getOrderAmount(String orderId) {
        return database.get(orderId);
    }
}
