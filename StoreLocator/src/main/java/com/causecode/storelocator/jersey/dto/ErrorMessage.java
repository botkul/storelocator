package com.causecode.storelocator.jersey.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private int erroCode;
	private String erroMessage;
	private String documentation;
	
	public ErrorMessage(){}
	
	public ErrorMessage(int erroCode,String errorMessage,String documentation){
		this.erroCode=erroCode;
		this.erroMessage=errorMessage;
		this.documentation=documentation;
	}

	public int getErroCode() {
		return erroCode;
	}

	public void setErroCode(int erroCode) {
		this.erroCode = erroCode;
	}

	public String getErroMessage() {
		return erroMessage;
	}

	public void setErroMessage(String erroMessage) {
		this.erroMessage = erroMessage;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}
