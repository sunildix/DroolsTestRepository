package com.sample;

public class DrlMessage {
	
	private String code;
	private String desc;
	
	public DrlMessage(String drlCode,String drlMessage) {
		this.code=drlCode;
		this.desc=drlMessage;
		System.out.println("Constructed..");
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	 
   public String toString(){
	   return "Error code : "+this.code +"\nError message : "+this.desc;
   }

}
