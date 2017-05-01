package commands;

import backend.PartGenerator;
import backend.User;
import db.OrderMapper;
import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class OrderCommand extends UserCommand implements ICommand
{

    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));

        User user = getSessionUser(request);

        PartGenerator pg = new PartGenerator(length, width);

        if (new OrderMapper().storeOrder(user, length, width, pg.getMaterials()))
        {
            request.setAttribute("message", "you've ordered the carport");
        }
        else
        {
            request.setAttribute("message", "Something went wrong, please try again");
        }
        return request.getRequestDispatcher("index.jsp");
    }

}
