package com.sample;

public class DocumentHelper {

	public DrlMessage msg;

	public boolean checkExtAgreementCommon(Object obj, String str1, String str2) {

		System.out.println("Creating fake Document helper class..");
		return true;
	}

	public boolean checkExtAgreementSize(Object obj, String str1) {

		System.out.println("Creating fake Document helper class..");
		return true;
	}

	public DrlMessage createError(String code, String desc) {
		System.out.println("Processing done....");
		System.out.println("Invoking createError..");
		this.msg = new DrlMessage(code, desc);

		return this.msg;
	}

	public DrlMessage getError() {
		System.out.println("Generating error..");
		return this.msg;
	}
}
