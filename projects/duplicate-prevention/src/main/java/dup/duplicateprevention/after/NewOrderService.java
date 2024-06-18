package dup.duplicateprevention.after;

import dup.duplicateprevention.core.Database;
import org.springframework.stereotype.Service;

@Service
public class NewOrderService {
    private Database database;

    public NewOrderService(Database database) {
        this.database = database;
    }

    public synchronized void addOrder(String orderId, Long amount) {
        database.add(orderId, amount);
    }

    public Long getOrderAmount(String orderId) {
        return database.get(orderId);
    }
}
