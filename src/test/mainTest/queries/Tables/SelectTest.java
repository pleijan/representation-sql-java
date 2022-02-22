package mainTest.queries.Tables;

import main.Table;
import main.queries.Tables.*;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SelectTest implements LifecycleLoggerTest {

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
    @DisplayName("selectDistinct()- Create a Distinct attribute")
    void selectDistinct() {
        String att = "att1";
        Select instance = new Select();
        instance.selectDistinct(att);

        String expected = "DISTINCT("+att+")";

        assertEquals(expected, instance.getAttributes().get(0));
        assertEquals(1,instance.getAttributes().size());

    }

    @Test
    @DisplayName("selectUnique()- Create a Distinct attribute")
    void selectUnique() {
        String att = "att1";
        Select instance = new Select();
        instance.selectUnique(att);

        String expected = "UNIQUE("+att+")";

        assertEquals(expected, instance.getAttributes().get(0));
        assertEquals(1,instance.getAttributes().size());

    }

    @Test
    @DisplayName("where()- Adding condition")
    void where() {
        String tableName = "TestTable";
        String att = "att1";
        String operator = " = ";
        String value = "NEWVALUE";
        Table table = new Table(tableName);
        table.addElement(att);

        Select instance = new Select();
        instance.from(tableName); // Add the tableName to the query

        instance.where(table.get(att),operator,value);

        String expected = "WHERE "+table.get(att)+operator+value;

        assertEquals(expected, instance.getWheres().get(0));
        assertEquals(1,instance.getWheres().size());
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
    @DisplayName("join()- join one or several Tables")
    void join() {
        String tableName = "TestTable";
        String att1 = "att1";
        String att2 = "att2";
        String att3 = "att3";

        Table table = new Table(tableName);
        table.addElement(att1);
        table.addElement(att2);
        table.addElement(att3);

        String tableName2 = "TestTable2";
        String att21 = "att21";
        String att22 = "att22";
        String att23 = "att23";

        Table table2 = new Table(tableName2);
        table2.addElement(att21);
        table2.addElement(att22);
        table2.addElement(att23);

        String operatorJ = "=";

        String expected = "JOIN "+table2.getName()+" ON "+ table.get(att1) + " " + operatorJ +" "+table2.get(att21);

        Select instance = new Select();

        instance.from(tableName); // Add the tableName to the query

        instance.join(table2,table.get(att1),table2.get(att21),operatorJ);
        String test = instance.getJoins().get(0);
        assertEquals(instance.getJoins().get(0),expected);

    }

    @Test
    @DisplayName("group by tests")
    void groupBy() {
        String tableName = "TestTable";
        String att = "att1";
        String operator = " = ";
        String value = "NEWVALUE";
        Table table = new Table(tableName);
        table.addElement(att);
        // Creation of the query
        Select instance = new Select();
        instance.from(tableName); // Add the tableName to the query
        instance.groupBy(table.get(att));

        String expected = "GROUP BY "+table.get(att);
        String testo = instance.getGroupBy();
        assertEquals(expected, instance.getGroupBy());

    }

    @Test
    @DisplayName("order by tests")
    void orderBy() {
        String tableName = "TestTable";
        String att = "att1";
        String operator = " = ";
        String value = "NEWVALUE";
        Table table = new Table(tableName);
        table.addElement(att);
        // Creation of the query
        Select instance = new Select();
        instance.from(tableName); // Add the tableName to the query
        instance.orderBy(table.get(att),"DESC");

        String expected = "ORDER BY "+table.get(att)+" DESC";
        String testo = instance.getOrderBys().get(0);
        assertEquals(expected, instance.getOrderBys().get(0));

    }

    @Test
    @DisplayName("printQuery() - The complete Query of SELECT")
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

        String tableName2 = "TestTable2";
        String att21 = "att21";
        String att22 = "att22";
        String att23 = "att23";

        Table table2 = new Table(tableName2);
        table2.addElement(att21);
        table2.addElement(att22);
        table2.addElement(att23);

        Select instance = new Select();


        instance.from(tableName); // Add the tableName to the query


        // Select the attributes
        instance.select(table.get(att1));
        instance.selectUnique(table.get(att2));
        instance.selectDistinct(table.get(att3));

        //Test attributes
        String expected = "SELECT "+tableName+"."+att1+", UNIQUE("+tableName+"."+att2+"), DISTINCT("+tableName+"."+att3+") FROM "+tableName;
        assertEquals(expected+";",instance.printQuery());

        // Create joins
        String operatorJoin = "=";
        instance.join(table2, table.get(att1), table2.get(att21), operatorJoin);
        expected += " JOIN TestTable2 ON "+table.get(att1)+" "+operatorJoin+" "+table2.get(att21);
        assertEquals(expected+";",instance.printQuery());

        // Create a condition
        String operator = " >= ";
        String value = "NEWVALUE";
        instance.where(table.get(att1),operator,value);

        // Test one condition
        expected+= " WHERE "+table.get(att1)+operator+value;
        assertEquals(expected+";",instance.printQuery());

        // Create a second condition
        operator = " = ";
        value = "NEWVALUE2";
        instance.where(table.get(att2),operator,value);

        // Test 2 conditions
        expected += " AND WHERE "+table.get(att2)+operator+value;
        assertEquals(expected+";",instance.printQuery());

        // Test GROUP BY
        expected += " GROUP BY "+table.get(att1);
        instance.groupBy(table.get(att1));
        assertEquals(expected+";",instance.printQuery());

        // Test GROUP BY
        expected += " ORDER BY "+table.get(att1) +" ASC, "+table2.get(att21) +" ASC";
        instance.orderBy(table.get(att1),null);
        instance.orderBy(table2.get(att21),null);
        String testo = instance.printQuery();
        assertEquals(expected+";",instance.printQuery());
    }


}