package commands.admin;

import backend.Material;
import backend.User;
import db.DBFacade;
import interfaces.ICommand;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class AddMaterialCommand implements ICommand {

    @Override
    public RequestDispatcher execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user.isAdmin()) {
            String material_name = request.getParameter("material_name");
            Material m = new Material(material_name);
            DBFacade df = new DBFacade();

            df.addNewMaterial(m);
            ArrayList<String> list = df.getAllMaterials();
            request.setAttribute("list", list);
            return request.getRequestDispatcher("admin-materials.jsp");
        }else{
          return request.getRequestDispatcher("index.jsp");
        }
    }

}
