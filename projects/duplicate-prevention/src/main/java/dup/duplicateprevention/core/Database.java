package dup.duplicateprevention.core;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Database {
    private Map<String, Long> database = new HashMap<>();

    public void add(String key, Long value) {
        sleep(100);

        if (database.containsKey(key)) {
            database.put(key, database.get(key) + value);
        } else {
            database.put(key, value);
        }
    }

    public Long get(String key) {
        if (database.containsKey(key)) {
            return database.get(key);
        } else {
            return 0L;
        }
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
