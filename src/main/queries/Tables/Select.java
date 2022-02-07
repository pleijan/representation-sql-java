package main.queries.Tables;

import main.queries.Query;

import java.util.ArrayList;

public class Select extends Query {

    private ArrayList<String> tables;

    /**
     * Default Constructor of Select
     */
    public Select() {
        super();
        this.tables = new ArrayList<String>();
    }

    /**
     * Add an attribute to select
     * @param _attribute an attribute of a table
     */
    public void select(String _attribute) {
        this.attributes.add(_attribute);
    }

    @Override
    public String getTableName() {
        return this.tables.toString();
    }

    @Override
    public void from(String _tableName) {
        this.tables.add(_tableName);
    }

    @Override
    public String printQuery() {
        String query = "SELECT "+ listAsString(this.attributes) + " FROM "+ listAsString(this.tables);

        // Add WHERE Conditions
        if(this.wheres.size() > 0){
            query += " "+listAsString(this.wheres).replace(", "," AND ");
        }

        return query+";";

    }

    /**
     * Getter of Tables
     * @return the list of Table
     */
    public ArrayList<String> getTables() {
        return tables;
    }

    /**
     * Create a distinct attribute for the query
     * @param _attribute the attribute to distinct
     */
    public void selectDistinct(String _attribute) {
        this.attributes.add("DISTINCT("+_attribute+")");
    }

    /**
     * Create a unique attribute for the query
     * @param _attribute the attribute to make unique
     */
    public void selectUnique(String _attribute){
        this.attributes.add("UNIQUE("+_attribute+")");
    }



}

