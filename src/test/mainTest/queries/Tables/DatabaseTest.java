package mainTest.queries.Tables;

import main.Database;
import main.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class DatabaseTest {

    @Test
    void database() {

        Database db = new Database("dbname");

        Assertions.assertEquals(db.getName(),"dbname");

    }

    @Test
    void addTable() {
        Database db = new Database("dbname");
        Table table = new Table("tableName");
        db.addTable(table);

        ArrayList<Table> listTable = new ArrayList<Table>();
        listTable.add(table);

        Assertions.assertEquals(db.getListTables(),listTable);
    }
}