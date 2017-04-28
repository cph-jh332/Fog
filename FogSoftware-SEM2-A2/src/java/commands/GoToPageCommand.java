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
public class GoToPageCommand implements ICommand
{
    private String page;
    
    public GoToPageCommand(String page)
    {
        this.page = page;
    }
    
    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        return request.getRequestDispatcher(page);
    }
    
}
