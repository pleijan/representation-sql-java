package mainTest.queries.Tables;


import mainTest.LifecycleLoggerTest;
import main.Table;
import main.queries.Tables.Drop;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DropTest implements LifecycleLoggerTest {


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
    @DisplayName("queryString()- The final step of the Class")
    void printQuery() {
        String tableName = "TestTable";
        String stringQuery = "DROP TABLE "+ tableName;
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Drop instance = new Drop();
        instance.from(tableName); // Add the tableName to the query

        assertEquals(stringQuery,instance.printQuery());

    }
}