package main.queries.Tables;

import main.queries.Query;

import java.util.ArrayList;

/**
 * This class reproduces the action of the CREATE method in SQL, it is used to create a database or a table
 */

public class Create extends Query {

    private boolean state;
    private String name;

    /**
     * default constructor of Create
     */
    public Create(){
    }

    /**
     * this function set the state of the create function
     * @param state
     */
    public void addState(Boolean state){
        this.state = state;
    }

    /**
     * this function set the name of the create function
     * @param name
     */
    public void addName(String name){
        this.name = name;
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
