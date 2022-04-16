package main.queries.Tables;

import main.Column;
import main.queries.Query;

import java.util.ArrayList;

/**
 * This class reproduces the action of the DROP method in SQL, it is used to drop a table
 */

public class Drop extends Query {

    private boolean state;
    private String name;
    /**
     * Default constructor of Drop
     */
    public Drop() {
        tableName = "";
    }

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
    public String printQuery() {
        String query = "";
        if (state)
        {
            return("DROP DATABASE "+name+";");
        }
        else {
            query += "DROP TABLE " + name+";";
            return query;
        }
    }

    @Override
    public void where(String _attribute, String _operator, String _value) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Getter of Name
     * @return the name of the created object
     */
    public String getName() {
        return name;
    }
}

