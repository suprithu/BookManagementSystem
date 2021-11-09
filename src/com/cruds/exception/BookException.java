package com.cruds.exception;

public class BookException extends RuntimeException
{
private String info;
	
	public BookException(String info)
	{
		this.info = info;
	}

	public String getInfo()
	{
		return info;
	}

}
