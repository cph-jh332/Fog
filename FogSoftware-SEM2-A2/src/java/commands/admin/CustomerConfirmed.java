/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.admin;

import backend.Material;
import backend.OrderProgressCalc;
import backend.PartGenerator;
import backend.User;
import db.DBFacade;
import interfaces.ICommand;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author craci
 */
public class CustomerConfirmed implements ICommand {

    DBFacade df = new DBFacade();
    OrderProgressCalc opc = new OrderProgressCalc();

    @Override
    public RequestDispatcher execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null && user.isAdmin()) {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            boolean customerConfirmed = Boolean.parseBoolean(request.getParameter("customerConfirmed"));
            HashMap<String, Boolean> progress = df.getProgress(orderID);

            df.updateCustomerConfirmed(orderID, customerConfirmed);

            boolean hasCalled = progress.get("hasCalled");
            int orderProgress = opc.orderProgress(hasCalled, customerConfirmed);

            request.setAttribute("hasCalled", hasCalled);
            request.setAttribute("customerConfirmed", customerConfirmed);
            request.setAttribute("orderProgress", orderProgress);
            request.setAttribute("orderID", orderID);

            ArrayList<Material> od = df.getOrderDetail(orderID);
            HashMap<String, Integer> map = df.getLengthAndWidth(orderID);
            if (map != null) {
                int length = map.get("length");
                int width = map.get("width");

                PartGenerator pg = new PartGenerator(length, width);

                request.setAttribute("length", length);
                request.setAttribute("width", width);
                request.setAttribute("pillars", pg.getPillarAmount());
                request.setAttribute("rafters", pg.getRafterAmount());

                request.setAttribute("materials", od);
            }
            return request.getRequestDispatcher("admin-projectpage.jsp");
        }
        return request.getRequestDispatcher("index.jsp");
    }
}
