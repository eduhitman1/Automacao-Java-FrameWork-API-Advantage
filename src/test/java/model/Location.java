package model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Location {
	private int id;
	private String city;
	private String country;
	private List<Address> address;

}
