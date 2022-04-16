package main.queries.Tables;

import main.Column;
import main.queries.Query;
import java.util.ArrayList;

/**
 * This class reproduces the action of the CREATE method in SQL, it is used to create a database or a table
 */

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
            query += "CREATE TABLE " + name + " (";
            for (Column column : columns) {
                query +=  "\n" +column.getName() + " " + column.getDataType() + " " + column.getNullable();
            }
            return query + " ;";
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


}
