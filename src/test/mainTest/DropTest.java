package mainTest;


import main.Table;
import main.queries.Tables.Drop;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * This is the class for testing the deletion of a table
 */

class DropTest implements LifecycleLoggerTest {

    DropTest(){};


    @Test
    @DisplayName("from()- The table used in the query")
    void from() {
        String tableName = "TestTable";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Drop instance = new Drop();
        instance.from(tableName); // Add the tableName to the query


        assertEquals(testTable.getName(),instance.getTableName());
        assertNotEquals("",instance.getTableName());
    }

    @Test
    @DisplayName("printQuery()- The final step of the Class")
    void printQuery() {
        String tableName = "TestTable";
        String stringQuery = "DROP TABLE "+ tableName +";";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Drop instance = new Drop();
        instance.addName(tableName); // Add the tableName to the query
        instance.addState(false);
        assertEquals(stringQuery,instance.printQuery());
    }

    @Test
    void printQueryDatabase() {
        Drop instance = new Drop();
        instance.addName("DBName");
        instance.addState(Boolean.TRUE);
        String queryString="DROP DATABASE DBName;";
        assertEquals(instance.printQuery(),queryString);
    }

    @Test
    void getName() {
        Drop instance = new Drop();
        String name = "DBName";
        instance.addName(name);
        assertEquals(instance.getName(),name);
    }
}