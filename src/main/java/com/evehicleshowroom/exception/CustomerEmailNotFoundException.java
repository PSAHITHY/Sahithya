package com.evehicleshowroom.exception;

public class CustomerEmailNotFoundException extends RuntimeException 
{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public CustomerEmailNotFoundException(String msg)
 {
	 super(msg);
 }
}
