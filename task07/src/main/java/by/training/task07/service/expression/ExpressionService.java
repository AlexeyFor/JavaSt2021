package by.training.task07.service.expression;

import by.training.task07.service.ServiceException;

public interface ExpressionService {

    public String calculateExpressionInString(String expression) throws ServiceException;
}
