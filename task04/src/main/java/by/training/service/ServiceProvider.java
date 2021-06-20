package by.training.service;



public class ServiceProvider {

	private static ServiceProvider instance = new ServiceProvider();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public  Logic getLogic() {
		return LogicImpl.getInstance();
	}
	
	public  CarLogic getCarLogic() {
		return CarLogicImpl.getInstance();
	}

}
