package main.queries.Tables;

import main.queries.Query;

import java.util.ArrayList;

/**
 * This class reproduces the action of the DROP method in SQL, it is used to drop a table
 */

public class Drop extends Query {

    /**
     * Default constructor of Drop
     */
    public Drop() {
        tableName = "";
    }

    @Override
    public String printQuery() {
        if (tableName == "") {
            System.err.println("The Table name is missing.");
            return "";
        } else {
            return "DROP TABLE " + tableName + ";";
        }
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

