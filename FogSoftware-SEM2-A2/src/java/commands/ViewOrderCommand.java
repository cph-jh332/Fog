/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import db.OrderMapper;
import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bade
 */
public class ViewOrderCommand implements ICommand
{

    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        request.setAttribute("materials", new OrderMapper().getOrderDetail(orderID));
        return request.getRequestDispatcher("admin-projectpage.jsp");
    }

}
