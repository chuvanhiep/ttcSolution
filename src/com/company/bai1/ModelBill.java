package com.company.bai1;

public class ModelBill {
    int id;
    String name;
    long Money;
    String date;
    public ModelBill(int id, String name, long money, String date) {
        this.id = id;
        this.name = name;
        Money = money;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoney() {
        return Money;
    }

    public void setMoney(long money) {
        Money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ModelBill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Money=" + Money +
                ", ngaylapdon='" + date + '\'' +
                '}';
    }
}
