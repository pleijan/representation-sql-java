package main.queries.Tables;

import main.queries.Query;

import java.util.ArrayList;
import java.util.Iterator;

public class Delete extends Query {

    //default constructor
    public Delete(){
        super();
    }


    //print the query
    @Override
    public String printQuery() {
        String query = "DELETE FROM "+ tableName;

        // Add WHERE Conditions
        if(this.wheres.size() > 0){
            query += " "+listAsString(this.wheres," AND ");
        }

        return query+";";
    }
}

