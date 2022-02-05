package mainTest.queries.Tables;

import main.Table;
import main.queries.Tables.*;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SelectTest implements LifecycleLoggerTest {

    @Test
    @DisplayName("select()-")
    void select() {
        String tableName = "TestTable";
        String att = "att1";
        // Creation of the table
        Table testTable = new Table(tableName);
        testTable.addElement(att);
        // Creation of the query
        Select instance = new Select();
        instance.from(tableName); // Add the tableName to the query

        instance.select(testTable.get(att));
        String expected = tableName+'.'+att;
        assertTrue(instance.getAttributes().contains(tableName+'.'+att));
        assertEquals(1,instance.getAttributes().size());


    }

    @Test
    @DisplayName("from()-")
    void from() {
    }

    @Test
    @DisplayName("printQuery()-")
    void printQuery() {
    }
}