package main.queries;

import java.util.ArrayList;

public abstract class Query {

    protected String tableName;
    protected ArrayList<String> attributes;


    public Query() {
        this.tableName = "";
        this.attributes = new ArrayList<String>();
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    /**
     * Add the table used in this query
     * Setter of tableName
     * @param _table the used table
     */
    public void from(String _table) {
        this.tableName = _table;
    }

    /**
     * Getter of tableName
     * @return
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Create and return a String of the complete query
     * @return the query as a String
     */
    public String printQuery() throws Exception {
        throw new Exception("Not implemented yet");
    }

    /**
     * Create a String with all the string of the given ArrayList
     * @param _list the list of element (Attributes, Tables etc)
     * @return the elements separate by a comma and space
     */
    protected String listAsString(ArrayList<String> _list) {
        String res = "";

        // Save each string except the last one in this form: (as example)
        // attribute, attribute, attribute,
        // table, table, table
        for(int i = 0; i<_list.size()-1; i++) {
            res += _list.get(i) +", ";
        }

        // And then add the last string without the comma
        res += _list.get(_list.size()-1);

        return res;
    }
}
