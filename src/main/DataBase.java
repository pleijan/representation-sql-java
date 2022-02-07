package main;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Table> listTables;
    private String name;

    /**
     * default constructor of Database
     * @param name name of the database
     */
    public void Database(String name){
        this.name = name;
    }

    /**
     * function who add a table to the database
     * @param table table to add into the database
     */
    public void addTable(Table table){
        listTables.add(table);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Table> getListTables() {
        return listTables;
    }
}
