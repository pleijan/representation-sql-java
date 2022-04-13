package main;

import java.util.ArrayList;

/**
 * This class represents a database in SQL, so it has a name and a list of tables
 */

public class Database {
    private ArrayList<Table> listTables;
    private String name;

    /**
     * default constructor of Database
     * @param name name of the database
     */
    public Database(String name){
        this.name = name;
        this.listTables = new ArrayList<Table>();
    }

    /**
     * function who add a table to the database
     * @param table table to add into the database
     */
    public void addTable(Table table){
        listTables.add(table);
    }

    /**
     * getter of name
     * @return name of the database
     */
    public String getName() {
        return name;
    }

    /**
     * getter of listTables
     * @return an arrayList of tables
     */
    public ArrayList<Table> getListTables() {
        return listTables;
    }
}
