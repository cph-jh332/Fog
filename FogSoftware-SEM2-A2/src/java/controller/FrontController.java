package controller;

import backend.Material;
import backend.Order;
import backend.PartGenerator;
import backend.TextFiles;
import backend.User;
import db.MaterialMapper;
import db.OrderMapper;
import db.UserMapper;
import java.io.IOException;
import java.util.ArrayList;
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
        response.setContentType("text/jsp;charset=UTF-8");

        RequestDispatcher rd = null;
        OrderMapper om = new OrderMapper();
        MaterialMapper mp = new MaterialMapper();
        String action = request.getParameter("action");
        User currentUser = (User) request.getSession().getAttribute("user");

        // If no form is submitted
        if (action == null /*&& currentUser != null*/) {
            //rd = goToShop(request);
            response.sendRedirect("index.jsp");
            return;
        }

        switch (action) {

            case "admin-home": {
                User user = (User) request.getSession().getAttribute("user");
                if (user.isAdmin()) {
                    ArrayList orderList = om.getOrders("sqltop10");
                    request.setAttribute("list", orderList);
                    rd = request.getRequestDispatcher("admin.jsp");
                } else {
                    request.setAttribute("message", "you're not logged in or Admin");
                    rd = request.getRequestDispatcher("index.jsp");
                }
                break;
            }

            case "login": {

                currentUser = new UserMapper().loginUser(request.getParameter("email"), request.getParameter("password"));
                if (currentUser != null) {
                    request.getSession().setAttribute("user", currentUser);
                    ArrayList orderList = om.getOrders("sqltop10");

                    if (currentUser.isAdmin()) {
                        request.setAttribute("list", orderList);
                        rd = request.getRequestDispatcher("admin.jsp");
                    } else {
                        rd = request.getRequestDispatcher("index.jsp");
                    }
                } else {
                    request.setAttribute("message", "Failed login error.");
                    rd = request.getRequestDispatcher("/index.jsp");
                }
                break;
            }

            case "logout": {
                request.getSession().invalidate();
                rd = request.getRequestDispatcher("index.jsp");
                break;
            }

            case "see-materials": {
                ArrayList<String> list = mp.getAllMaterials();
                request.setAttribute("list", list);
                rd = request.getRequestDispatcher("admin-materials.jsp");
                break;
            }

            case "see-projects": {
                ArrayList orderList = om.getOrders("sqlall");
                request.setAttribute("list", orderList);
                rd = request.getRequestDispatcher("admin-projects.jsp");
                break;
            }

            case "add-material": {
                request.setCharacterEncoding("UTF-8");
                String material_name = request.getParameter("material_name");

                Material m = new Material(material_name);

                new MaterialMapper().addNewMaterial(m);

                ArrayList<String> list = mp.getAllMaterials();

                request.setAttribute("list", list);

                rd = request.getRequestDispatcher("admin-materials.jsp");

                break;
            }

            case "signup": {
                String email = request.getParameter("email");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                int phone = Integer.parseInt(request.getParameter("phone"));
                String password = request.getParameter("password");

                User newUser = new User(email, firstName, lastName, phone);

                UserMapper userMapper = new UserMapper();
                userMapper.createUser(newUser, password);

                rd = request.getRequestDispatcher("index.jsp");

                break;
            }

            case "create_carport": {
                //int height = Integer.parseInt(request.getParameter("height"));

                int length = Integer.parseInt(request.getParameter("length"));
                int width = Integer.parseInt(request.getParameter("width"));

                PartGenerator pg = new PartGenerator(length, width);

                // Create order in DB
                //Order o = new Order(666, Integer.toString(length) + "x" + Integer.toString(width));
                //new OrderMapper().storeOrder(currentUser, o, pg.generateMaterialList());
                request.setAttribute("length", length);
                request.setAttribute("width", width);
                request.setAttribute("pillars", pg.getPillarAmount());
                request.setAttribute("rafters", pg.getRafterAmount());

                rd = request.getRequestDispatcher("carport-2d.jsp");

                break;

            }

            case "order": {
                int length = Integer.parseInt(request.getParameter("length"));
                int width = Integer.parseInt(request.getParameter("width"));

                User user = (User) request.getSession().getAttribute("user");

                PartGenerator pg = new PartGenerator(length, width);

                if (new OrderMapper().storeOrder(user, length, width, pg.getMats())) {
                    request.setAttribute("message", "you've ordered the carport");
                } else {
                    request.setAttribute("message", "Something went wrong, please try again");
                }
                rd = request.getRequestDispatcher("index.jsp");
                break;
            }
            
            case "viewOrder": {
                
              //  int orderID = integer.parseInt(request.getParameter())
                
             //   new OrderMapper().getOrderDetail()
                
                
                
                
            }

            //default: {
            //response.sendRedirect("index.jsp");
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
