package org.telran.prof.com.homework23;

import java.util.HashMap;
import java.util.Map;

public class AccountData {
    private Map<String, Storage> data = new HashMap<>();

    public AccountData(Map<String, Storage> data) {
        this.data = data;
    }

    public Map<String, Storage> getData() {
        return data;
    }
}
