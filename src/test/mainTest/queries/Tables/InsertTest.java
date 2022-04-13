package mainTest.queries.Tables;

import main.Table;
import main.queries.Tables.Insert;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * This is the class for testing the insertion of values into a table
 */

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

        assertEquals(testTable.getName(),instance.getTableName());
        assertNotEquals("",instance.getTableName());
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

        assertEquals(instance.getListCol().size(),3);
        assertEquals(instance.getListAttribute().size(),3);
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

        assertEquals(instance.getListCol().size(),0);
        assertEquals(instance.getListAttribute().size(),3);
    }

    @Test
    void printQuery() {

        String tableName = "TestTable";
        String stringQuery = "INSERT INTO "+ tableName +" (col1, col2, col3) VALUES (val1, val2, val3);";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Insert instance = new Insert();
        instance.from(tableName); // Add the tableName to the query

        instance.insert("col1","val1");
        instance.insert("col2","val2");
        instance.insert("col3","val3");

        assertEquals(stringQuery,instance.printQuery());

        // -------------------------------------------

        String tableName1 = "TestTable";
        String stringQuery2 = "INSERT INTO "+ tableName +" VALUES (val1, val2, val3);";
        // Creation of the table
        Table testTable1 = new Table(tableName);

        // Creation of the query
        Insert instance1 = new Insert();
        instance1.from(tableName1); // Add the tableName to the query

        instance1.insert("val1");
        instance1.insert("val2");
        instance1.insert("val3");

        assertEquals(stringQuery2,instance1.printQuery());

    }
}