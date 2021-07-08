package by.training.task05.service;

public class ServiceProvider {

    private static ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
	return instance;
    }

    public SphereLogic getSphereLogic() {
	return SphereLogicImpl.getInstance();
    }

    public RepositoryLogic getRepositoryLogic() {
	return RepositoryLogicImpl.getInstance();
    }

}
