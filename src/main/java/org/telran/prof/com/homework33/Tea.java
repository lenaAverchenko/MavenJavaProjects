package org.telran.prof.com.homework33;

import java.util.UUID;

public class Tea {
    private String uuid;
    private String nameOfTea;

    public Tea(String uuid, String nameOfTea) {
        this.uuid = uuid;
        this.nameOfTea = nameOfTea;
    }

    public Tea(String nameOfTea) {
        this(UUID.randomUUID().toString(), nameOfTea);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNameOfTea() {
        return nameOfTea;
    }

    public void setNameOfTea(String nameOfTea) {
        this.nameOfTea = nameOfTea;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "uuid='" + uuid + '\'' +
                ", nameOfTea='" + nameOfTea + '\'' +
                '}';
    }
}
