package com.hibernate.annotation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpSalary {
	
	@Column(name="basic")
	private int basic;
	
	@Column(name="hra")
	private int hra;
	
	@Column(name="gross")
	private int gorss;
	
	
	public EmpSalary(){
		
	}
	
	public EmpSalary(int basic, int hra, int gorss) {
		this.basic = basic;
		this.hra = hra;
		this.gorss = gorss;
	}

	/**
	 * @return the basic
	 */
	public int getBasic() {
		return basic;
	}

	/**
	 * @param basic the basic to set
	 */
	public void setBasic(int basic) {
		this.basic = basic;
	}

	/**
	 * @return the hra
	 */
	public int getHra() {
		return hra;
	}

	/**
	 * @param hra the hra to set
	 */
	public void setHra(int hra) {
		this.hra = hra;
	}

	/**
	 * @return the gorss
	 */
	public int getGorss() {
		return gorss;
	}

	/**
	 * @param gorss the gorss to set
	 */
	public void setGorss(int gorss) {
		this.gorss = gorss;
	}
	
	

}
