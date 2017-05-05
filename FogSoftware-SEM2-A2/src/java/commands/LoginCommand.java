package commands;

import backend.User;
import db.DBFacade;
import interfaces.ICommand;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ICommand
{
    private final String userLogin = "index.jsp";
    private final String adminLogin = "admin.jsp";
    private final String failedLogin = "index.jsp";
    private DBFacade df = new DBFacade();
    
    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        User currentUser = df.loginUser(request.getParameter("email"), request.getParameter("password"));
        if (currentUser != null)
        {
            request.getSession().setAttribute("user", currentUser);
            if (currentUser.isAdmin())
            {
                ArrayList orderList = df.getOrders("sqltop10");
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