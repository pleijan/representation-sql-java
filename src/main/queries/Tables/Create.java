package main.queries.Tables;

import main.queries.Query;

public class Create extends Query {

    private boolean state;
    private String name;

    /**
     * default constructor of Create
     * @param state state of the create 1 for DATABASE, 0 for TABLE
     * @param name Name of the object we want to create
     */
    public Create(Boolean state, String name){
        this.state = state;
        this.name=name;
    }

    @Override
    public String printQuery(){
        if (state==true) return("CREATE DATABASE "+name+";");
        else return("CREATE TABLE "+name+";");
    }

    public boolean getState(){
        return state;
    }

    public String getName() {
        return name;
    }
}
