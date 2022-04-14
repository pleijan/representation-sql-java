package main.queries.Tables;

import main.Table;
import main.queries.Query;
import java.util.ArrayList;

public class Select extends Query {

    private ArrayList<String> tables;
    private ArrayList<String> joins;
    private ArrayList<String> groupBys;
    private ArrayList<String> orderBys;

    /**
     * Default Constructor of Select
     */
    public Select() {
        super();
        this.tables = new ArrayList<>();
        this.joins = new ArrayList<>();
        this.groupBys = new ArrayList<>();
        this.orderBys = new ArrayList<>();
    }

    /**
     * Getter of Tables
     * @return the list of Table
     */
    public ArrayList<String> getTables() {
        return tables;
    }

    /**
     * Getter of Joins
     * @return the list of JOIN statement
     */
    public ArrayList<String> getJoins()
    {
        return joins;
    }

    /**
     * Getter of GroupBys
     * @return the list of GROUP BY statement
     */
    public ArrayList<String> getGroupBys()
    {
        return groupBys;
    }

    /**
     * Getter of OrderBys
     * @return the list of ORDER BY statement
     */
    public ArrayList<String> getOrderBys()
    {
        return orderBys;
    }

    @Override
    public String getTableName() {
        return this.tables.toString();
    }

    /**
     * Add an attribute to select
     * @param _attribute an attribute of a table
     */
    public void select(String _attribute) {
        this.attributes.add(_attribute);
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

    @Override
    public void from(String _tableName) {
        this.tables.add(_tableName);
    }

    /**
     * TEMPORARY JOIN
     * NEED TO BE REPLACED BY SEVERAL METHODS OR DECORATOR
     * https://sql.sh/cours/jointures
     * Add a JOIN statement to the query
     * @param typeJoin      the type of join (INNER, OUTER, LEFT, RIGHT)
     * @param secondTableName   the second table to join with
     * @param firstField    the field of the first table to check the JOIN statement
     * @param secondField   the field of the second table to check the JOIN statement
     * @param operator      the operator
     */
    public void join(String typeJoin, String secondTableName, String firstField, String secondField, String operator)
    {
        String joinQuery = typeJoin + " JOIN " + secondTableName +
                " ON " + firstField + " " + operator + " "  + secondField;

        this.joins.add(joinQuery);
    }

    /**
     * Add a GROUP BY Statement to the query
     * @param field     the attribute
     */
    public void groupBy(String field)
    {
        this.groupBys.add(field);
    }

    /**
     * Add a ORDER BY statement to the query
     * @param field     the attribute
     * @param order     the order to sort
     */
    public void orderBy(String field, String order)
    {
        String orderBy = switch (order.toUpperCase()) {

            // Descendant order
            case "DESC" -> field + " DESC";

            // Ascendant order
            case "ASC" -> field + " ASC";

            // Default (ascendant) order
            default -> field;
        };

        this.orderBys.add(orderBy);
    }

    @Override
    public String printQuery() {
        String query = "SELECT "+ listAsString(this.attributes) + " FROM "+ listAsString(this.tables)+" ";

        //Add JOIN Conditions
        if(this.joins.size() > 0)
        {
            query += "" +listAsString(this.joins, " ");
        }

        // Add WHERE Conditions
        if(this.wheres.size() > 0){
            query += " "+listAsString(this.wheres," AND ");
        }

        // Add GROUP BY Conditions
       if(this.groupBys.size() > 0)
        {
            query += " GROUP BY "+listAsString(this.groupBys);
        }

        // Add ORDER BY Conditions
        if(this.orderBys.size() > 0){
            query += " ORDER BY "+listAsString(this.orderBys);
        }

        return query+";";
    }

}