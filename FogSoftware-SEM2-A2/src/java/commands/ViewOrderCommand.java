package commands;

import db.OrderMapper;
import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

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
