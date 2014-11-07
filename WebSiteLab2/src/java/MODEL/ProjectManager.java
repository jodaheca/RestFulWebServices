/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.Project;
import DTO.DataBase;
import DTO.FeedObjects;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Joaquin David
 */
public class ProjectManager {

    public ArrayList<FeedObjects> GetFeeds() throws Exception {
        ArrayList<FeedObjects> feeds = null;
        try {
            DataBase database = new DataBase();
            Connection connection = database.Get_Connection();
            Project project = new Project();
            feeds = project.GetFeeds(connection);
        } catch (Exception e) {
            throw e;
        }
        return feeds;
    }
    // Metodo encargado de hacer el llamado al DAO que registra una nueva pagina en la DB
    public int setFeeds( FeedObjects pagina) throws Exception{
        try{
            DataBase database = new DataBase();
            Connection connection = database.Get_Connection();
            Project project = new Project();
            int resultado = project.SetFeeds(connection,pagina);
            return resultado;
        }catch(Exception e){
            System.out.println("Error"+ e.toString());
            return 0 ;
        }
    }
}
