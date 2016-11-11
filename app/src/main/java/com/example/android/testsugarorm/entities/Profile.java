package com.example.android.testsugarorm.entities;

import android.graphics.Color;

import com.example.android.testsugarorm.utils.DateUtils;
import com.orm.SugarRecord;

/**
 * Project: TestORM
 *
 * @package: com.example.android.testsugarorm.entity
 * <p>
 * Created by Sven on 10.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */
public class Profile extends SugarRecord {

    String name;
    String description;
    String url;
    String api_key;
    String secret;
    int color = Color.parseColor("#1976d2");  // material blue 700
    String lastAccess;
    String created;

    public Profile(){
        this.lastAccess = DateUtils.getTodayDateLong();
        this.created = DateUtils.getTodayDateLong();
    }

    public Profile(String name, String description, String url, String api_key, String secret, int color) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.api_key = api_key;
        this.secret = secret;
        this.color = color;
        this.lastAccess = DateUtils.getTodayDateLong();
        this.created = DateUtils.getTodayDateLong();

    }

    public void setName(String name ){
        this.name = name;
    }

    public void setDescription (String description){
        this.description = description;
    }

    public void setUrl (String url){
        this.url = url;
    }

    public void setApiKey(String api_key){
        this.api_key = api_key;
    }

    public void setSecret(String secret){
        this.secret = secret;
    }

    public void setColor(int color){
        this.color = color;
    }

    public void setLastAccess(String dateStr ){
        this.lastAccess = dateStr;
    }

    public String getName(){ return this.name; }

    public String getDescription() {return this.description; }

    public int getColor() { return this.color; }


    @Override
    public String toString() {
        return "Profile{" +
                "name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", url='" + this.url + '\'' +
                ", api_key='" + this.api_key + '\'' +
                ", secret='" + this.secret + '\'' +
                ", color=" + this.color +
                ", lastAccess='" + this.lastAccess + '\'' +
                ", created='" + this.created + '\'' +
                '}';
    }
}
