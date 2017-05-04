/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.admin;

import backend.User;
import db.DBFacade;
import interfaces.ICommand;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author craci
 */
public class AdminHomePage implements ICommand {

    @Override
    public RequestDispatcher execute(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("user");
        String admin = "admin.jsp";
        String notAdmin = "index.jsp";
        if (currentUser != null && currentUser.isAdmin()) {
            ArrayList orderList = new DBFacade().getOrders("sqltop10");
            request.setAttribute("list", orderList);
            return request.getRequestDispatcher(admin);
        }
        return request.getRequestDispatcher(notAdmin);
    }

}
