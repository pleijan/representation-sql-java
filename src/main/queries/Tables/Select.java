package main.queries.Tables;

import main.queries.Query;

import java.util.ArrayList;

public class Select extends Query {

    private ArrayList<String> attributes;
    private ArrayList<String> tables;

    /**
     * Default Constructor of Select
     */
    Select() {
        this.attributes = new ArrayList<String>();
        this.tables = new ArrayList<String>();
    }

    /**
     * Add an attribute to select
     * @param _attribute an attribute of a table
     */
    public void select(String _attribute) {
        this.attributes.add(_attribute);
    }

    /**
     * Create a String with all the string of the given ArrayList
     * @param _list the list of element (Attributes, Tables etc)
     * @return the elements separate by a comma and space
     */
    private String listAsString(ArrayList<String> _list) {
        String res = "";

        // Save each string except the last one in this form: (as example)
        // attribute, attribute, attribute,
        // table, table, table
        for(int i = 0; i<_list.size()-2; i++) {
            res += _list.get(i) +", ";
        }

        // And then add the last string without the comma
        res += _list.get(_list.size()-1);

        return res;
    }

    @Override
    public void from(String _tableName) {
        this.tables.add(_tableName);
    }

    @Override
    public String queryString() {
        return "SELECT "+ listAsString(this.attributes) + " FROM "+ listAsString(this.tables);
    }
}

