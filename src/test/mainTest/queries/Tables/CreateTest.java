package mainTest.queries.Tables;

import main.queries.Tables.Create;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateTest implements LifecycleLoggerTest {


    @Test
    void CreateTable(){
        Create instance = new Create(false,"TableName");

        assertFalse(instance.getState());
        assertEquals(instance.getName(),"TableName");
    }

    @Test
    void CreateDatabase(){
        Create instance = new Create(true,"DBName");

        assertTrue(instance.getState());
        assertEquals(instance.getName(),"DBName");
    }

    @Test
    void printQueryTable() {
        Create instance = new Create(false,"TableName");
        String queryString="CREATE TABLE TableName;";
        assertEquals(instance.printQuery(),queryString);
    }

    @Test
    void printQueryDatabase() {
        Create instance = new Create(true,"DBName");
        String queryString="CREATE DATABASE DBName;";
        assertEquals(instance.printQuery(),queryString);
    }
}