/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import backend.User;
import db.UserMapper;
import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bade
 */
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
