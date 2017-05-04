package commands.admin;

import backend.Material;
import backend.PartGenerator;
import backend.OrderProgressCalc;
import db.DBFacade;
import interfaces.ICommand;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class ViewOrderCommand implements ICommand {

    DBFacade df = new DBFacade();
    OrderProgressCalc opc = new OrderProgressCalc();
    
    @Override
    public RequestDispatcher execute(HttpServletRequest request) {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        ArrayList<Material> od = df.getOrderDetail(orderID);
        HashMap<String, Integer> map = df.getLengthAndWidth(orderID);
        HashMap<String, Boolean> progress = df.getProgress(orderID);
        
        boolean hasCalled = progress.get("hasCalled");
        boolean customerConfirmed = progress.get("customerConfirmed");
        
        int orderProgress = opc.orderProgress(hasCalled, customerConfirmed);
        
        request.setAttribute("hasCalled", hasCalled);
        request.setAttribute("customerConfirmed", customerConfirmed);
        request.setAttribute("orderProgress", orderProgress);
        request.setAttribute("orderID", orderID);
        
        if (map != null) {
            int length = map.get("length");
            int width = map.get("width");

            PartGenerator pg = new PartGenerator(length, width);

            request.setAttribute("length", length);
            request.setAttribute("width", width);
            request.setAttribute("pillars", pg.getPillarAmount());
            request.setAttribute("rafters", pg.getRafterAmount());
        }
        request.setAttribute("materials", od);
        return request.getRequestDispatcher("admin-projectpage.jsp");
    }

}
