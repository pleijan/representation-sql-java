package main;

import main.queries.Tables.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the Main class, it allows to try our library
 */

public class main {

    public static void main(String[] args) {

        // ------------------ Test de la fonction CREATE ( BD ET TABLE) ----------------------
        Create createBd = new Create();
        createBd.addName("BdTest");
        createBd.addState(true);
        String Bdname= createBd.getName();
        Boolean isDatabase = createBd.getState();
        createBd.printQuery();

        Create createTable = new Create();
        createTable.addName("tabletest");
        createTable.addState(false);
        createTable.addColumn("why","varchar(255)",true);
        String tableNametest = createTable.getName();
        Boolean isTable = createTable.getState();
        createTable.printQuery();

        // ------------------ Test de la fonction Delete ----------------------

        Delete deleteTest = new Delete();
        deleteTest.from("tableok");
        deleteTest.where("ok",">","5");
        deleteTest.printQuery();


        // ------------------ Test de la fonction Drop ----------------------

        // Creation of the table tableName
        Table testTable = new Table("tableName");
        testTable.addElement("ok");
        ArrayList<String> testArray = testTable.getElements();
        String testArrayElement = testTable.get("ok");
        testTable.removeElement("ok");
        String tableName = testTable.getName();

        // Creation of the query
        Drop instance = new Drop();
        instance.addState(false);
        instance.addName("tableName");
        String tableDropName = instance.getName();

        System.out.println(instance.printQuery());

        //ooooooo by BD

        // Creation of the query
        Drop instanceDb = new Drop();
        instanceDb.addState(true);
        instanceDb.addName("tableName");

        System.out.println(instanceDb.printQuery());

        // ------------------------------------------------------------------

        // ----------------- Test de la fonction Update ---------------------

        String tableName1 = "TestTable";
        // Creation of the table
        Table testTableUpdate = new Table("tableName");

        // Creation of the query
        Update instanceUpdate = new Update();
        instanceUpdate.from(tableName1); // Add the tableName to the query


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

        // SELECT COVER------------------------------------
        Select selectInstance = new Select();
        selectInstance.from("testSel");
        selectInstance.select("test1");
        selectInstance.selectDistinct("test2");
        selectInstance.selectUnique("test3");
        selectInstance.join("INNER","impossible","oui","oui","=");
        selectInstance.groupBy("oui");
        selectInstance.orderBy("oui","asc");
        System.out.println(selectInstance.printQuery());

        //Data base tests

        Database databaseTest = new Database("fouki");
        databaseTest.addTable(testTable);
        String dataBaseTestName = databaseTest.getName();
        List<Table> alltable = databaseTest.getListTables();

        //SQL test

        SQL.Make(SQL.SQLCOMMANDS.CREATE);
        SQL.Make(SQL.SQLCOMMANDS.DROP);
        SQL.Make(SQL.SQLCOMMANDS.INSERT);
        SQL.Make(SQL.SQLCOMMANDS.DELETE);
        SQL.Make(SQL.SQLCOMMANDS.UPDATE);
        SQL.Make(SQL.SQLCOMMANDS.SELECT);


        //run interface try all option to get all coverage

        InterfaceCLI client = new InterfaceCLI();


    }
}