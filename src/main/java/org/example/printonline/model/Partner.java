package org.example.printonline.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.printonline.model.enums.PaperFormat;

import java.time.LocalTime;

@Getter
@Setter
public class Partner {

    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private String address;
    private float latitude;
    private float longitude;

    /**
     * 0 indexed (e.g. 0 == Monday)
     */
    private WorkingDay[] schedule;
    private PartnerServices partnerServices;
}

@Getter
@Setter
@AllArgsConstructor
class WorkingDay {

    private WorkingHours[] workingHours;
}

@Getter
@Setter
@AllArgsConstructor
class WorkingHours {

    private LocalTime from;
    private LocalTime to;
}

@Getter
@Setter
@AllArgsConstructor
class PartnerServices{
    private PaperFormat paperFormat;
    private boolean isColoured;
    private int price;
}
