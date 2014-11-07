/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FeedObjects;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Joaquin David
 */
public class Project {
     public ArrayList<FeedObjects> GetFeeds(Connection connection) throws Exception {
        ArrayList<FeedObjects> feedData = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT title,description,url FROM website ORDER BY id DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedObjects feedObject1 = new FeedObjects();
                feedObject1.setTitle(rs.getString("title"));
                feedObject1.setDescription(rs.getString("description"));
                feedObject1.setUrl(rs.getString("url"));
                feedData.add(feedObject1);
            }
            return feedData;

        } catch (Exception e) {
            throw e;
        }

    }
     // Metodo que inserta la nueva pagina en la DB
     public int SetFeeds(Connection connection, FeedObjects pagina) throws Exception {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO website(title,description,url) VALUES(?,?,?)");
            ps.setString(1,pagina.getTitle());
            ps.setString(2, pagina.getDescription());
            ps.setString(3, pagina.getUrl());
            System.out.println(ps.toString());
            ps.execute();
            return 1;

        } catch (Exception e) {
            System.out.println("Error ingresando la pagina " + e.toString() );
            return 0;
        }

    }
}
