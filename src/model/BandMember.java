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
	@Column(name="MUSICIANID")
	private int id;
	@Column(name="MEMBERNAME")
	private String name;
	@Column(name="INSTRUMENT")
	private String instrument;
	@Column(name="BANDID")
	private int bandid;
	
	

	public BandMember() {
		super();
	}	

	public BandMember(String name, String instrument) {
		super();

		this.name = name;
		this.instrument = instrument;
	}

	public String getBandName() {
		return bandName;
	}
	
	public int getBandid() {
		return bandid;
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
		String bandName = this.getName(thi);
		return name + " plays " + instrument + " in " + bandName + "\n";
	}
	
}
