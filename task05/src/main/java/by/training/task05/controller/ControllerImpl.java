package by.training.task05.controller;

public class ControllerImpl implements Controller {

    private static final ControllerImpl controller = new ControllerImpl();

    private ControllerImpl() {
    }

    public static ControllerImpl getController() {
	return controller;
    }

    public String doAction(String request) {
	String response;
	String[] params;
	String CommandName;

	params = request.split("___");
	CommandName = params[0];

	CommandProvider provider = CommandProvider.getсommandProvider();
	Command com = provider.getCommand(CommandName);

	response = com.execute(params);

	return response;
    }
}
