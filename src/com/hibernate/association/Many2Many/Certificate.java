package com.hibernate.association.Many2Many;

public class Certificate implements Comparable<Certificate> {

	private int id;

	private String name;

	public Certificate() {

	}

	public Certificate(String name) {
		this.name = name;
	}

	public int compareTo(Certificate certificate) {

		final int BEFORE = -1;
		final int AFTER = 1;

		if (certificate == null) {
			return BEFORE;
		}

		String thisCertificateName = this.getName();
		String thatCertificateName = certificate.getName();

		if (thisCertificateName == null) {
			return AFTER;
		} else if (thatCertificateName == null) {
			return BEFORE;
		} else {
			
			return thisCertificateName.compareTo(thatCertificateName);
		}
	}

	public int hashCode() {
		return (id + name).hashCode();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
