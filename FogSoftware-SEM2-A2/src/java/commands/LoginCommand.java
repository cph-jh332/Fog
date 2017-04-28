package commands;

import backend.User;
import interfaces.ICommand;
import db.OrderMapper;
import db.UserMapper;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ICommand
{
    private final String userLogin = "index.jsp";
    private final String adminLogin = "admin.jsp";
    private final String failedLogin = "index.jsp";
    
    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        User currentUser = new UserMapper().loginUser(request.getParameter("email"), request.getParameter("password"));
        if (currentUser != null)
        {
            request.getSession().setAttribute("user", currentUser);
            if (currentUser.isAdmin())
            {
                ArrayList orderList = new OrderMapper().getOrders("sqltop10");
                request.setAttribute("list", orderList);
                return request.getRequestDispatcher(adminLogin);
            }
            else
            {
                return request.getRequestDispatcher(userLogin);
            }
        }
        request.setAttribute("message", "Failed login error.");
        return request.getRequestDispatcher(failedLogin);
    }
}
