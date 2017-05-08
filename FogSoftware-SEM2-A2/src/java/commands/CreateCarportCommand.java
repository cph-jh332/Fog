package commands;

import backend.PartGenerator;
import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class CreateCarportCommand implements ICommand
{

    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));

        PartGenerator pg = new PartGenerator(length, width);

        request.getSession().setAttribute("length", length);
        request.getSession().setAttribute("width", width);
        request.setAttribute("pillars", pg.getPillarAmount());
        request.setAttribute("rafters", pg.getRafterAmount());

        return request.getRequestDispatcher("view-order.jsp");
    }

}
