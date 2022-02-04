package main.queries;

public interface Query {

    /**
     * Add the table used in this query
     * @param _table the used table
     */
    void from(String _table);

    /**
     * Create and return a String of the complete query
     * @return the query as a String
     */
    String queryString();

}
