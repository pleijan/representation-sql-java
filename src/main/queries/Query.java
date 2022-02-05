package main.queries;

public abstract class Query {

    protected String tableName;
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
    public String queryString() throws Exception {
        throw new Exception("Not implemented yet");
    }

}
