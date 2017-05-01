package commands;

import backend.User;
import interfaces.ICommand;
import db.OrderMapper;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class SeeProjectCommand extends UserCommand implements ICommand
{

    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        User user = getSessionUser(request);
        if (loggedIn(user) && user.isAdmin())
        {
            ArrayList orderList = new OrderMapper().getOrders("sqlall");
            request.setAttribute("list", orderList);
            return request.getRequestDispatcher("admin-projects.jsp");
        }
        return request.getRequestDispatcher("index.jsp");
    }

}