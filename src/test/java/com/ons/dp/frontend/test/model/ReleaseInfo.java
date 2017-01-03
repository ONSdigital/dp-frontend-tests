package com.ons.dp.frontend.test.model;


public class ReleaseInfo {
	public String header;
	public String image;
	public String contact;
	public String contact_email;
	public String releaseDate;
	public String nextRelease;

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getimage() {
		return image;
	}

	public void setOns_image(String image) {
		this.image = image;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getNextRelease() {
		return nextRelease;
	}

	public void setNextRelease(String nextRelease) {
		this.nextRelease = nextRelease;
	}
}
