package commands.admin;

import backend.User;
import db.DBFacade;
import interfaces.ICommand;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class AdminHomePage implements ICommand {

    private String admin = "admin.jsp";
    private String notAdmin = "index.jsp";
    
    @Override
    public RequestDispatcher execute(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("user");
        if (currentUser != null && currentUser.isAdmin()) {
            ArrayList orderList = new DBFacade().getOrders("sqltop10");
            request.setAttribute("list", orderList);
            return request.getRequestDispatcher(admin);
        }
        return request.getRequestDispatcher(notAdmin);
    }

}
