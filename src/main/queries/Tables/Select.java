package main.queries.Tables;

import main.Table;
import main.queries.Query;

import java.util.ArrayList;

public class Select extends Query {

    private ArrayList<String> tables;
    private ArrayList<String> joins;
    private String groupBy;
    private ArrayList<String> orderBys;

    /**
     * Default Constructor of Select
     */
    public Select() {
        super();
        this.tables = new ArrayList<String>();
        this.joins = new ArrayList<String>();
        this.orderBys = new ArrayList<String>();
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

        //Add JOIN Conditions

        if(this.joins.size() > 0)
        {
            query += " " + listAsString(this.joins).replace(", ", " ");
        }

        // Add WHERE Conditions
        if(this.wheres.size() > 0){
            query += " "+listAsString(this.wheres).replace(", "," AND ");
        }

        // Add groupBy
       if(this.groupBy != null)
        {
            query += " " + groupBy;
        }

        if(this.orderBys.size() > 0){
            query += " "+listAsString(this.orderBys);
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

    public ArrayList<String> getJoins()
    {
        return joins;
    }

    public String getGroupBy()
    {
        return groupBy;
    }

    public ArrayList<String> getOrderBys()
    {
        return orderBys;
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

    public void join(Table secondTable, String firstField, String secondField, String operator)
    {
        String joinQuerry = "JOIN " + secondTable.getName() + " ON " + firstField + " " + operator + " "  +secondField;

        this.joins.add(joinQuerry);
    }

    public void groupBy(String field)
    {
       if(this.groupBy == null)
        {
            this.groupBy = "GROUP BY " + field;
        }
        else
        {
            throw new UnsupportedOperationException("A query cannot have more than 1 GROUP BY clause.");
        }
    }

    public void orderBy(String field, String operator)
    {
        String orderBy = "";

        if(orderBys.size() <= 0)
        {
            orderBy = "ORDER BY ";
        }

        orderBy +=field +" ";

            if(operator == null)
            {
                orderBy += "ASC";
            }
            else
            {
                orderBy += operator;
            }

        this.orderBys.add(orderBy);
    }
 

}

