/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import backend.User;
import interfaces.ICommand;
import db.OrderMapper;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bade
 */
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
