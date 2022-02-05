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
        return "SELECT "+ listAsString(this.attributes) + " FROM "+ listAsString(this.tables);
    }
}

