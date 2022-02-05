package main.queries.Tables;

import main.queries.Query;

import java.util.ArrayList;

public class Insert extends Query {

    ArrayList<String> listCol;
    ArrayList<String> listAttribute;

    /**
     * default constructor for insert
     */
    public Insert() {
        super();
        listCol = new ArrayList<String>();
        listAttribute = new ArrayList<String>();
    }

    /**
     * Add an attribute to insert
     *
     * @param col    column to add value
     * @param newVal val of the col
     */
    public void insert(String col, String newVal) {
        listCol.add(col);
        listAttribute.add(newVal);
    }

    /**
     * Add an attribute to insert
     *
     * @param newVal new val for the insert
     */
    public void insert(String newVal) {
        listAttribute.add(newVal);
    }

    @Override
    public String printQuery() {
        if (listCol.size() == 0) {
            return "INSERT INTO " + getTableName() + " VALUES (" + listAsString(listAttribute) + ");";
        } else
            return "INSERT INTO " + getTableName() + "( + " + listAsString(listCol) + ") VALUES (" + listAsString(listAttribute) + ");";
    }
}
