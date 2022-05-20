package model;

import lombok.Builder;
import lombok.Data;


//More complex

@Data
public class Address {
    private String street;
    private String flat_no;
    private int pincode;
    private String type;
}