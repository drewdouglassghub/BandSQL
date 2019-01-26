package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="musicians")
public class BandMember {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="instrument")
	private String instrument;
	
	//ArrayList<String> daysAvail = new ArrayList<String>();

	public BandMember() {
		super();
	}	

	public BandMember(int id, String name, String instrument) {
		super();
		this.id = id;
		this.name = name;
		this.instrument = instrument;
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

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}	
	
	public String memberDetails() {
		return name + " - " + instrument;
	}
	
}
