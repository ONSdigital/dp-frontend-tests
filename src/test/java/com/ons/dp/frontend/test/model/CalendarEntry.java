package com.ons.dp.frontend.test.model;

public class CalendarEntry {
	public String summary = "";
	public String provisionalDateRange = "";
	public String finalise = "";
	public String nextRelease = "";
	public String contactName = "";
	public String contactEmail = "";
	public String telephone = "";
	public String image = "";
	public String cancelled = "";
	public String releaseDate = "";

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getProvisionalDateRange() {
		return provisionalDateRange;
	}

	public void setProvisionalDateRange(String provisionalDateRange) {
		this.provisionalDateRange = provisionalDateRange;
	}

	public String getFinalise() {
		return finalise;
	}

	public void setFinalise(String finalise) {
		this.finalise = finalise;
	}

	public String getNextRelease() {
		return nextRelease;
	}

	public void setNextRelease(String nextRelease) {
		this.nextRelease = nextRelease;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOnsimage() {
		return image;
	}

	public void setOnsimage(String onsimage) {
		this.image = onsimage;
	}

	public String getCancelled() {
		return cancelled;
	}

	public void setCancelled(String cancelled) {
		this.cancelled = cancelled;
	}
}
