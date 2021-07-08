package by.training.task05.dal;

import java.util.List;

public interface WorkWithFile {

	public List<String> readFileList(String path) throws DALException;

}
