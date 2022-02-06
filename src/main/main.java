package main;

import main.queries.Tables.Drop;
import main.queries.Tables.Insert;
import main.queries.Tables.Update;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        // ----------------- Test de la fonction Insert ----------------------
        String tableNameInsert = "TestTable";
        // Creation of the table
        Table testTableInsert = new Table(tableNameInsert);

        // Creation of the query
        Insert instanceInsert = new Insert();
        instanceInsert.from(tableNameInsert); // Add the tableName to the query

        instanceInsert.insert("col1","val1");
        instanceInsert.insert("col2","val2");
        instanceInsert.insert("col3","val3");

        System.out.println(instanceInsert.printQuery());

        // -------------------------------------------


        // Creation of the table
        Table testTable1 = new Table(tableName);

        // Creation of the query
        Insert instanceInsert2 = new Insert();
        instanceInsert2.from(tableNameInsert); // Add the tableName to the query

        instanceInsert2.insert("val1");
        instanceInsert2.insert("val2");
        instanceInsert2.insert("val3");

        System.out.println(instanceInsert2.printQuery());
    }
}