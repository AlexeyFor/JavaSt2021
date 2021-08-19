package by.training.task08.controller;

/**
 * 
 * request in the form "command___arguments
 * 
 * @author AlexeySupruniuk
 */
public interface Command {
    public String execute(String[] request);
}
