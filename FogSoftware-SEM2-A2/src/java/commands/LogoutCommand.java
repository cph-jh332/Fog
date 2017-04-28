package commands;

import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ICommand
{
    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return request.getRequestDispatcher("index.jsp");
    }
}
