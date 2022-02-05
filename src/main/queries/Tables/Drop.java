package main.queries.Tables;

import main.queries.Query;

public class Drop extends Query {

    /**
     * Default constructor of Drop
     */
    public Drop(){
        tableName = "";
    }

    @Override
    public void from(String _table) { tableName = _table; }

    @Override
    public String queryString(){
        if (tableName == "") {
            System.err.println("The Table name is missing.");
            return "";
        } else {
            return "DROP TABLE " + tableName;
        }

    }
}
