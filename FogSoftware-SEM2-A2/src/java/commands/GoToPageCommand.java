package commands;

import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class GoToPageCommand implements ICommand
{
    private String page;
    
    public GoToPageCommand(String page)
    {
        this.page = page;
    }
    
    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        return request.getRequestDispatcher(page);
    }
    
}
