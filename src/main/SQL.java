package main;


import main.queries.Query;
import main.queries.Tables.*;

/**
 * This class is composed of the SQL operators and the query factory
 */
public class SQL {
    // OPERATOR
    public static final String EQUAL = " = ";
    public static final String NOTEQUAL = " <> ";
    public static final String GT = " > ";
    public static final String LT = " < ";
    public static final String GTE = " >= ";
    public static final String LTE = " <= ";
    public static final String IN = " IN ";
    public static final String BETWEEN = " BETWEEN";
    public static final String LIKE = " LIKE ";
    public static final String ISNULL = " IS NULL ";
    public static final String NOTNULL = " IS NOT NULL ";
    public static final String DESC = " DESC ";
    public static final String ASC = " ASC ";


    /**
     * Fabric for Query element
     * WIP
     * @param _query the name of the query
     * @return a Query object
     */
    public Query make(String _query) {
        switch (_query.toLowerCase()) {

            case "select":
                return new Select();

            case "drop":
                return new Drop();

            case "insert":
                return new Insert();

            case "update":
                return new Update();

            case "create":
                return new Create();
            default:
                return null;
        }
    }

    

}


