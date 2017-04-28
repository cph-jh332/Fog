package controller;

import commands.AddMaterialCommand;
import commands.CreateCarportCommand;
import commands.GoToPageCommand;
import interfaces.ICommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.NullCommand;
import commands.OrderCommand;
import commands.SeeMaterialsCommand;
import commands.SeeProjectCommand;
import commands.SignUpCommand;
import commands.ViewOrderCommand;
import java.util.HashMap;

public class CommandFactory
{
    private static HashMap<String, ICommand> commandMap;
    
    private CommandFactory(){}; // Private constructor for simulated static class //
    
    public static ICommand getCommand(String action)
    {   
        return commandMap.get(action);
    }
    
    public static void initializeCommands()
    {
        commandMap = new HashMap();
        commandMap.put("login", new LoginCommand());
        commandMap.put("logout", new LogoutCommand());
        commandMap.put("create-carport", new CreateCarportCommand());
        commandMap.put("order", new OrderCommand());
        commandMap.put("see-materials", new SeeMaterialsCommand());
        commandMap.put("see-projects", new SeeProjectCommand());
        commandMap.put("signup", new SignUpCommand());
        commandMap.put("viewOrder", new ViewOrderCommand());
        commandMap.put("add-material", new AddMaterialCommand());
        commandMap.put("admin-home", new GoToPageCommand("admin.jsp"));
        commandMap.put(null, new NullCommand());
    }
}
