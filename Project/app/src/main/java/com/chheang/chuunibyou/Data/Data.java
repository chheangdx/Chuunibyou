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

    public Data(){

    }

    public Data(String id){
        this.id = id;
        name = "";
        description = "";
    }

    public Data(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
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
}
