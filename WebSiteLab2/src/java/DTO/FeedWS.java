/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joaquin David
 */
@XmlRootElement
public class FeedWS  implements java.io.Serializable{
     private String title;
     private String description;
     private String url;

    public FeedWS() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
     
}
