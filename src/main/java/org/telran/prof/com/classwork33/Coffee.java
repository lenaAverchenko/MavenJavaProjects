package org.telran.prof.com.classwork33;

import java.util.UUID;

public class Coffee {
    private String uuid;
    private  String name;

    public Coffee(String name) {
        this(UUID.randomUUID().toString(),name);
    }

    public Coffee(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String id) {
        this.uuid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
