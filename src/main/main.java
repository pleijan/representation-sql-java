package main;

import main.queries.Tables.Drop;

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
    }
}