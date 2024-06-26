package com.talshavit.groupbuyproject.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class User {
    private String name;
    private ArrayList<Order> histories;

    public User() {
        this.histories = new ArrayList<>();
    }

    public User(String name, ArrayList<Order> histories) {
        this.name = name;
        this.histories = histories;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Order> getHistories() {
        return histories;
    }

    public User setHistories(ArrayList<Order> histories) {
        this.histories = histories;
        return this;
    }

    public void addHistory(Order history) {
        histories.add(history);

        Collections.sort(histories, new Comparator<Order>() {
            @Override
            public int compare(Order order1, Order order2) {
                int dateComparison = order2.getDate().compareTo(order1.getDate());
                if (dateComparison == 0) {
                    return order2.getTime().compareTo(order1.getTime());
                }
                return dateComparison;
            }
        });
    }
}

