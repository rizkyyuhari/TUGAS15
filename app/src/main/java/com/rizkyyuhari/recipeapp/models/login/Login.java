package com.rizkyyuhari.recipeapp.models.login;

import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("uname")
	private String uname;

	@SerializedName("result_code")
	private int resultCode;

	@SerializedName("status")
	private String status;

	public void setUname(String uname){
		this.uname = uname;
	}

	public String getUname(){
		return uname;
	}

	public void setResultCode(int resultCode){
		this.resultCode = resultCode;
	}

	public int getResultCode(){
		return resultCode;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}