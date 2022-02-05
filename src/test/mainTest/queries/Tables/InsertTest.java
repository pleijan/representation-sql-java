package mainTest.queries.Tables;

import main.Table;
import main.queries.Tables.Insert;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertTest implements LifecycleLoggerTest {

    @Test
    @DisplayName("from()")
    void from() {
        String tableName = "TestTable";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Insert instance = new Insert();
        instance.from(tableName); // Add the tableName to the query

    }

    @Test
    void insert() {
        String tableName = "TestTable";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Insert instance = new Insert();
        instance.from(tableName); // Add the tableName to the query

        instance.insert("col1","val1");
        instance.insert("col2","val2");
        instance.insert("col3","val3");
    }

    @Test
    void testInsert() {

        String tableName = "TestTable";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Insert instance = new Insert();
        instance.from(tableName); // Add the tableName to the query

        instance.insert("val1");
        instance.insert("val2");
        instance.insert("val3");
    }

    @Test
    void printQuery() {

        String tableName = "TestTable";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Insert instance = new Insert();
        instance.from(tableName); // Add the tableName to the query

        instance.insert("col1","val1");
        instance.insert("col2","val2");
        instance.insert("col3","val3");

        System.out.println(instance.printQuery());

        // -------------------------------------------

        String tableName1 = "TestTable";
        // Creation of the table
        Table testTable1 = new Table(tableName);

        // Creation of the query
        Insert instance1 = new Insert();
        instance1.from(tableName1); // Add the tableName to the query

        instance1.insert("val1");
        instance1.insert("val2");
        instance1.insert("val3");

        System.out.println(instance1.printQuery());

    }
}