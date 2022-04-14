package main.queries.Tables;

import main.Column;
import main.queries.Query;
import java.util.ArrayList;

public class Create extends Query {

    private boolean state;
    private String name;
    private ArrayList<Column> columns;

    /**
     * default constructor of Create
     */
    public Create(){
        columns = new ArrayList<>();
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

    public void addColumn(String name, String dataType, boolean nullable)
    {
        columns.add(new Column(name,dataType,nullable));
    }

    @Override
    public String printQuery(){
        String query = "";
        if (state)
        {
            return("CREATE DATABASE "+name+";");
        }
        else {
            query += "CREATE TABLE " + name + " ( \n";
            for (Column column : columns) {
                query += column.getName() + " " + column.getDataType() + " " + column.getNullable() + "\n";
            }
            return query;
        }
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
