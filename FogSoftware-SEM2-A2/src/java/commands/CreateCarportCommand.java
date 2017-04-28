/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import backend.PartGenerator;
import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bade
 */
public class CreateCarportCommand implements ICommand
{

    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));

        PartGenerator pg = new PartGenerator(length, width);

        request.setAttribute("length", length);
        request.setAttribute("width", width);
        request.setAttribute("pillars", pg.getPillarAmount());
        request.setAttribute("rafters", pg.getRafterAmount());

        return request.getRequestDispatcher("carport-2d.jsp");
    }

}
