package main.queries.Tables;

import main.queries.Query;

import java.util.ArrayList;

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

    /**
     * Getter of State
     * @return a boolean true for DATABASE, false for TABLE
     */
    public boolean getState(){
        return state;
    }

    /**
     * Getter of Name
     * @return the name of the created object
     */
    public String getName() {
        return name;
    }


    @Override
    public void where(String _attribute, String _operator, String _value) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public ArrayList<String> getWheres() {
        throw new UnsupportedOperationException("Method not implemented");
    }
}
