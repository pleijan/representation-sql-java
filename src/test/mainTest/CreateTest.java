package mainTest;

import main.queries.Tables.Create;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the class to test the creation of databases and tables
 */

public class CreateTest implements LifecycleLoggerTest {

    public CreateTest(){};

    @Test
    void CreateTable(){
        Create instance = new Create();
        instance.addName("TableName");
        instance.addState(Boolean.FALSE);

        assertFalse(instance.getState());
        assertEquals(instance.getName(),"TableName");
    }

    @Test
    void CreateDatabase(){
        Create instance = new Create();
        instance.addName("DBName");
        instance.addState(Boolean.TRUE);

        assertTrue(instance.getState());
        assertEquals(instance.getName(),"DBName");
    }

    @Test
    void printQueryTable() {
        Create instance = new Create();
        instance.addName("TableName");
        instance.addState(Boolean.FALSE);
        instance.addColumn("ok","bit",true);
        String queryString="CREATE TABLE TableName (\nok bit NULL ;";
        assertEquals(instance.printQuery(),queryString);
    }

    @Test
    void printQueryDatabase() {
        Create instance = new Create();
        instance.addName("DBName");
        instance.addState(Boolean.TRUE);
        String queryString="CREATE DATABASE DBName;";
        assertEquals(instance.printQuery(),queryString);
    }
}