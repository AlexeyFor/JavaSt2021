package by.training.task05.service;

import java.util.List;

import by.training.task05.entity.Sphere;

public interface RepositoryLogic {

    /**
     * Take List <String>, convert String into Specification, return List <Sphere>
     * as a result of query to repository
     * 
     * @param specificaions
     * @return List <Sphere>
     * @throws ServiceException
     */
    public List<Sphere> repositoryQuery(String[] specificaionsStr) throws ServiceException;

    /**
     * Initiation of repository, on repeated call adds files to the existing storage
     * 
     * @param path
     * @return boolean answer
     * @throws ServiceException
     */
    public boolean intiateRepository(String path) throws ServiceException;

    /**
     * Return Sphere from repository. If Sphere with such name is absent - throw
     * ServiceException
     * 
     * @param name
     * @return Sphere
     */
    public Sphere takeSphereFromRepository(String name) throws ServiceException;
}
