package commands;

import backend.User;
import javax.servlet.http.HttpServletRequest;

public abstract class UserCommand
{
    public User getSessionUser(HttpServletRequest request)
    {
        return (User) request.getSession().getAttribute("user");
    }
    
    public boolean loggedIn(User user)
    {
        return user != null;
    }
}
