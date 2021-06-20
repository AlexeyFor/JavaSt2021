package by.training.controller;

/**
 * request in the form "command___arguments
 * 
 * @author AlexeySupruniuk
 *
 */
public interface Command  {
	 public  String execute(String[] request);
}

