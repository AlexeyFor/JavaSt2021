package by.training.task06.dal;

import java.util.List;

public interface FileReaderInterface {

    public List<String> readFileList(String path) throws DALException;

}
