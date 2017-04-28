/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import backend.Material;
import db.MaterialMapper;
import interfaces.ICommand;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bade
 */
public class AddMaterialCommand implements ICommand
{

    @Override
    public RequestDispatcher execute(HttpServletRequest request)
    {
        String material_name = request.getParameter("material_name");
        Material m = new Material(material_name);
        MaterialMapper mp = new MaterialMapper();
        
        mp.addNewMaterial(m);
        ArrayList<String> list = mp.getAllMaterials();
        request.setAttribute("list", list);
        return request.getRequestDispatcher("admin-materials.jsp");
    }

}
