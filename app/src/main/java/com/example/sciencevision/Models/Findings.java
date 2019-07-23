package com.example.sciencevision.Models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;

@ParseClassName("Findings")
public class Findings extends ParseObject {
    //Values that are in the Parse Database
    private static final String KEY_USER= "User";
    private static final String KEY_NAME= "ItemName";
    private static final String KEY_DESCRIPTION= "ItemDescription";
    private static final String KEY_FACT= "FunFact";
    private static final String KEY_IMAGE= "ItemImage";
    private static final String KEY_EXPERIMENT="Experiment";
    private static final String KEY_CREATED= "createdAt";

    //Methods to get and set attributes for Findings
    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser user){
        put(KEY_USER,user);
    }
    public String getName(){
        return getString(KEY_NAME);
    }
    public void setName(String itemName){
        put(KEY_NAME,itemName);
    }
    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String itemDescription){
        put(KEY_DESCRIPTION,itemDescription);
    }
    public String getFunFact(){
        return getString(KEY_FACT);
    }
    public void setFunFact(String funFact){
        put(KEY_FACT,funFact);
    }
    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile image){
        put(KEY_IMAGE,image);
    }
    public String getExperiment(){
        return getString(KEY_EXPERIMENT);
    }
    public void setExperiment(String experiment){
        put(KEY_EXPERIMENT,experiment);
    }
    public String getNiceTime(){
        Date date = getParseUser(KEY_USER).getCreatedAt();
        PrettyTime time = new PrettyTime();
        return time.format(date).toString();
    }
    //Query
    public static class Query extends ParseQuery<Findings> {
        public Query() {
            super(Findings.class);
        }
    public Query getTop(){
        setLimit(20);
        return this; }
    public Query withUser(){
            include(KEY_USER);
            return this; }
    public Query getRecent(){
        getQuery(KEY_CREATED);
        return this;
    }
//    public Query getUser(){
//            whereExists("HBgEs258GT");
//            return this;
//    }
    }
}

