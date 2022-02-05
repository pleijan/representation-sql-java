package main;

import main.queries.Tables.Drop;
import main.queries.Tables.Update;

public class main {

    public static void main(String[] args) {

        // ------------------ Test de la fonction Drop ----------------------

        // Creation of the table tableName
        Table testTable = new Table("tableName");

        // Creation of the query
        Drop instance = new Drop();
        instance.from("tableName");

        System.out.println(instance.printQuery());

        // ------------------------------------------------------------------

        // ----------------- Test de la fonction Update ---------------------

        String tableName = "TestTable";
        // Creation of the table
        Table testTableUpdate = new Table("tableName");

        // Creation of the query
        Update instanceUpdate = new Update();
        instanceUpdate.from(tableName); // Add the tableName to the query


        instanceUpdate.update("col1","val1"); //Add couple of arguments to update

        System.out.println(instanceUpdate.printQuery());

        // -------------------------------------------------------------------
    }
}