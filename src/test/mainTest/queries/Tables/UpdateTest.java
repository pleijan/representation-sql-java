package mainTest.queries.Tables;

import main.Table;
import main.queries.Tables.Drop;
import main.queries.Tables.Update;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UpdateTest implements LifecycleLoggerTest{

    @Test
    @DisplayName("from()")
    void from() {
        String tableName = "TestTable";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Drop instance = new Drop();
        instance.from(tableName); // Add the tableName to the query

    }

    @Test
    @DisplayName("update()")
    void update() {
        String tableName = "TestTable";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Update instance = new Update();
        instance.from(tableName); // Add the tableName to the query


        instance.update("col1","val1"); //Add couple of arguments to update
    }


    @Test
    @DisplayName("queryString()-")
    void printQuery() {
        String tableName = "TestTable";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Update instance = new Update();
        instance.from(tableName); // Add the tableName to the query


        instance.update("col1","val1"); //Add couple of arguments to update

        System.out.println(instance.printQuery());
    }
}