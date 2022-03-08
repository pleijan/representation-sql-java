package mainTest.queries.Tables;

import main.Table;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {


    @Test
    void Table() {
        Table table = new Table("name");
        assertEquals(table.getName(),"name");
    }

    @Test
    void addElement() {
        Table table = new Table("name");
        table.addElement("element2");

        ArrayList<String> elem = new ArrayList<String>();
        elem.add("element2");

        assertEquals(table.getElements(),elem);
    }

    @Test
    void testAddElement() {
        Table table = new Table("name");
        String[] listeElem = new String[2];
        listeElem[1] = "elem1";
        listeElem[0] = "elem0";
        table.addElement(listeElem);

        ArrayList<String> elem = new ArrayList<String>();
        elem.add("elem0");
        elem.add("elem1");

        assertEquals(table.getElements(),elem);
    }

    @Test
    void removeElement() {
        Table table = new Table("name");
        table.addElement("element2");

        table.removeElement("element2");

        ArrayList<String> elem = new ArrayList<String>();
        assertEquals(table.getElements(),elem);
    }

}