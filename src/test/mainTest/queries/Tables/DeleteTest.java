package mainTest.queries.Tables;


import main.Table;
import main.queries.Tables.Create;
import main.queries.Tables.Delete;
import main.queries.Tables.Drop;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * This is the class for testing the deletion of a table
 */

class DeleteTest implements LifecycleLoggerTest {

    DeleteTest(){};

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
        String stringQuery = "DELETE FROM "+ tableName;
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Delete instance = new Delete();
        instance.from(tableName); // Add the tableName to the query
        assertEquals(stringQuery+";",instance.printQuery());

        // Create a condition
        String colName = "testo";
        String operator = " >= ";
        String value = "NEWVALUE";
        instance.where(colName,operator,value);

        // Test one condition
        stringQuery+= " WHERE "+colName+operator+value;
        String ok = instance.printQuery();
        assertEquals(stringQuery+";",instance.printQuery());
    }

}