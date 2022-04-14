package main;


import main.queries.Query;
import main.queries.Tables.*;

import javax.swing.plaf.basic.BasicMenuUI;
import static main.SQL.SQLCOMMANDS;
import static main.SQL.SQLCOMMANDS.CREATE;
import static main.SQL.SQLCOMMANDS.DROP;
import static main.SQL.SQLCOMMANDS.INSERT;
import static main.SQL.SQLCOMMANDS.UPDATE;
import static main.SQL.SQLCOMMANDS.DELETE;

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
    public static Query Make(SQLCOMMANDS _query) {
        switch (_query) {

            case CREATE:
                return new Create();

            case DROP:
                return new Drop();

            case INSERT:
                return new Insert();

            case SELECT:
                return new Select();

            case UPDATE:
                return new Update();

            case DELETE:
                return new Delete();
            default:
                return null;
        }
    }

    public enum SQLCOMMANDS
    {
        CREATE,
        DROP,
        INSERT,
        SELECT,
        UPDATE,
        DELETE
    }

    

}


