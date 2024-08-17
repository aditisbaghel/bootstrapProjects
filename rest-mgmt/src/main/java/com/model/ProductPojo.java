package com.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductPojo {
	private Integer ID;
	@Positive(message="Required")
	private Integer STOCK;
	@NotBlank(message="Required")
	private String NAME;
	@NotBlank(message="Required")
	private String GENRE;
	@NotBlank(message="Required")
	private String PRICE;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getSTOCK() {
		return STOCK;
	}
	public void setSTOCK(Integer sTOCK) {
		STOCK = sTOCK;
	}
	public String getNAME() {
		return NAME;
	}
	@Override
	public String toString() {
		return "ProductPojo [ID=" + ID + ", STOCK=" + STOCK + ", NAME=" + NAME + ", GENRE=" + GENRE + ", PRICE=" + PRICE
				+ "]";
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getGENRE() {
		return GENRE;
	}
	public void setGENRE(String gENRE) {
		GENRE = gENRE;
	}
	public String getPRICE() {
		return PRICE;
	}
	public ProductPojo(Integer iD, Integer sTOCK, String nAME, String gENRE, String pRICE) {
		super();
		ID = iD;
		STOCK = sTOCK;
		NAME = nAME;
		GENRE = gENRE;
		PRICE = pRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

	
}
