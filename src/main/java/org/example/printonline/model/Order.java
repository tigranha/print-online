package org.example.printonline.model;

import lombok.Getter;
import lombok.Setter;
import org.example.printonline.model.enums.OrderStatus;

import java.sql.Timestamp;

@Getter
@Setter
public class Order {

    private int id;
    private int userID;
    private int partnerID;
    private Timestamp createdAt;
    private Timestamp deadline;
    private int totalPrice;
    private OrderStatus status;
}
