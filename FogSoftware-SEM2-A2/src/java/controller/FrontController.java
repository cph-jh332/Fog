package controller;

import backend.Order;
import backend.PartGenerator;
import backend.TextFiles;
import backend.User;
import db.OrderMapper;
import db.UserMapper;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns
        = {
            "/FrontController"
        })
public class FrontController extends HttpServlet {

    TextFiles text = new TextFiles();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = null;
        String action = request.getParameter("action");
        User currentUser = (User) request.getSession().getAttribute("user");

        // If no form is submitted
        if (action == null /*&& currentUser != null*/) {
            //rd = goToShop(request);
            response.sendRedirect("index.html");
            return;
        }

        switch (action) {
            case "login": {
                
                currentUser = new UserMapper().loginUser(request.getParameter("username"), request.getParameter("password"));
                if (currentUser != null) {
                    request.getSession().setAttribute("user", currentUser);
                    //rd = goToShop(request);
                } else {
                    request.setAttribute("message", "Failed login error.");
                    rd = request.getRequestDispatcher("/index.jsp");
                }

                break;
            }

            case "create_carport": {
                //int height = Integer.parseInt(request.getParameter("height"));

                int length = Integer.parseInt(request.getParameter("length"));
                int width = Integer.parseInt(request.getParameter("width"));

                PartGenerator pg = new PartGenerator(length, width);

                // Create order in DB
                Order o = new Order(666, Integer.toString(length) + "x" + Integer.toString(width));
                new OrderMapper().storeOrder(currentUser, o);

                request.setAttribute("length", length);
                request.setAttribute("width", width);
                request.setAttribute("materialList", pg.generateMaterialList());

                rd = request.getRequestDispatcher("material-list.jsp");

                break;

            }

            //default: {
            //response.sendRedirect("index.html");
            //}
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
