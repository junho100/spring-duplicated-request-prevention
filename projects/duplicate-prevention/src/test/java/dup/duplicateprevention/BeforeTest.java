package dup.duplicateprevention;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dup.duplicateprevention.before.OrderService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeforeTest {
    @Autowired
    private OrderService orderService;

    @Test
    void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        CountDownLatch countDownLatch = new CountDownLatch(30);
        for (int i = 0; i < 30; i++) {
            executorService.submit(() -> {
                orderService.addOrder("order1", 100L);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        assertEquals(3000L, orderService.getOrderAmount("order1"));
    }
}
