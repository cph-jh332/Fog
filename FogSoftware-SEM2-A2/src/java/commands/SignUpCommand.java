package commands;

import backend.User;
import db.UserMapper;
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
        String password = request.getParameter("password");

        User newUser = new User(email, firstName, lastName, phone);

        UserMapper userMapper = new UserMapper();
        userMapper.createUser(newUser, password);

        return request.getRequestDispatcher("index.jsp");
    }

}
