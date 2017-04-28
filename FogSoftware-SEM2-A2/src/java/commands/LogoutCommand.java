/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import interfaces.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bade
 */
public class LogoutCommand implements ICommand
{
    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return request.getRequestDispatcher("index.jsp");
    }
}
