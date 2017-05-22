package interfaces;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public interface ICommand
{
    RequestDispatcher execute(HttpServletRequest request);
}