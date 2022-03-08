package mainTest.queries.Tables;

import main.queries.Tables.Create;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateTest implements LifecycleLoggerTest {


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
        String queryString="CREATE TABLE TableName;";
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