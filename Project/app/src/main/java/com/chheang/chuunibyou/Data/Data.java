package com.chheang.chuunibyou.Data;

import java.util.Date;

/**
 * Created by User on 1/5/2016.
 */
public class Data {
    private String id;
    private String name;
    private String description;
    //TODO icon
    private Date date;

    public Data(){
        id = "";
        name = "";
        description = "";
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
