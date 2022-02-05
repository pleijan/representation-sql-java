package mainTest.queries.Tables;

import main.Table;
import main.queries.Tables.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SelectTest {

    @Test
    @DisplayName("select()- Add an attribute to the Query")
    void select() {

        // Initialization
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
        assertTrue(instance.getAttributes().contains(expected));
        assertEquals(1,instance.getAttributes().size());


    }

    @Test
    @DisplayName("from()- Adding one or several Tables")
    void from() {
        String tableName = "TestTable";
        String tableName2 = "TestTable2";
        String tableName3 = "TestTable3";
        String tableName4 = "TestTable4";
        // Creation of the query
        Select instance = new Select();
        instance.from(tableName); // Add the tableName to the query

        assertEquals(1,instance.getTables().size());
        assertTrue(instance.getTables().contains(tableName));

        instance.from(tableName2);
        instance.from(tableName3);
        instance.from(tableName4);

        assertEquals(4,instance.getTables().size());
        assertTrue(instance.getTables().contains(tableName2));
        assertTrue(instance.getTables().contains(tableName3));
        assertTrue(instance.getTables().contains(tableName4));

    }

    @Test
    @DisplayName("printQuery()- The complete Query of SELECT")
    void printQuery() {
        // Initialization
        String tableName = "TestTable";
        String att1 = "att1";
        String att2 = "att2";
        String att3 = "att3";

        Table table = new Table(tableName);
        table.addElement(att1);
        table.addElement(att2);
        table.addElement(att3);
        Select instance = new Select();


        instance.from(tableName); // Add the tableName to the query

        // Select the attributes
        instance.select(table.get(att1));
        instance.select(table.get(att2));
        instance.select(table.get(att3));

        //Test
        String expected = "SELECT "+tableName+"."+att1+", "+tableName+"."+att2+", "+tableName+"."+att3+" FROM "+tableName+";";
        assertEquals(expected,instance.printQuery());

    }

    @Test
    @DisplayName("selectDistinct()- Create a Distinct attribute")
    void selectDistinct() {
        String att = "att1";
        Select instance = new Select();
        instance.selectDistinct(att);

        String expected = "DISTINCT("+att+")";

        assertEquals(expected, instance.getAttributes().get(0));

    }

    @Test
    @DisplayName("selectUnique()- Create a Distinct attribute")
    void selectUnique() {
        String att = "att1";
        Select instance = new Select();
        instance.selectUnique(att);

        String expected = "UNIQUE("+att+")";

        assertEquals(expected, instance.getAttributes().get(0));

    }
}