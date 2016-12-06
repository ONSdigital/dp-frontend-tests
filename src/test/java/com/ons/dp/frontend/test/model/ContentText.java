package com.ons.dp.frontend.test.model;


public enum ContentText {
	ECONOMY("economy"),
	GROSS_DOMESTIC_PRODUCT_GBP("grossdomesticproductgdp"),
	DATASETS("datasets"),
	BUSINESS_INVESTMENT("businessinvestment"),
	DOWNLOAD_OPTIONS("Download options"),
	UPDATE_ADD_SUPLEMENTARY_FILE("Update / Add supplementary file"),
	VERSIONS("Versions"),
	ADD_VERSION("Add version"),
	SAVE_SUBMIT_RETURN_TO_PARENT("Save, submit for review and back to parent"),
	SAVE_SUBMIT_FOR_REVIEW("Save and submit for review"),
	CURRENT("current"),
	SAVE_SUBMIT_FOR_APPROVAL("Save and submit for approval"),
	SAVE_SUBMIT_APPROVAL_RETURN_TO_PARENT("Save, submit for approval and back to parent"),
	APPROVE_COLLECTION("Approve collection");


	private final String contentString;

	ContentText(String contentString) {
		this.contentString = contentString;
	}

	public String getContentString() {
		return this.contentString;
	}

}

