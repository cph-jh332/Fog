package commands;

import backend.User;
import db.DBFacade;
import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements ICommand
{

    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String streetName = request.getParameter("streetName");
        String city = request.getParameter("city");
        int zipCode = Integer.parseInt(request.getParameter("zipCode"));
        String password = request.getParameter("password");

        User newUser = new User(email, firstName, lastName, phone, streetName, city, zipCode);

        DBFacade df = new DBFacade();
        df.createUser(newUser, password);

        return request.getRequestDispatcher("index.jsp");
    }

}
