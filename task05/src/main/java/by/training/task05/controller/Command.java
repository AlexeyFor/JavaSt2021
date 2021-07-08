package by.training.task05.controller;

/**
 * 
 * request in the form "command___arguments
 * 
 * @author AlexeySupruniuk
 */
public interface Command {
    public String execute(String[] request);
}
