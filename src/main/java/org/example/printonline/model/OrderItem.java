package org.example.printonline.model;

import lombok.Getter;
import lombok.Setter;
import org.example.printonline.model.enums.PaperFormat;

@Getter
@Setter
public class OrderItem {

    private int id;
    private String fileUrl;
    private String pages;
    private int copies;
    private int price;
    private boolean isColoured;
    private PaperFormat paperFormat;
    private int orderID;
}
