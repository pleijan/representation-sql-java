package mainTest;

import org.junit.jupiter.api.Test;
import main.Column;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnTest {

    @Test
    void Column(){
        Column instance = new Column("nameTest", "typeTest", false);
        assertEquals("nameTest", instance.getName());
        assertEquals("typeTest", instance.getDataType());
        assertEquals(" NOT NULL", instance.getNullable());
    }

    @Test
    void setName(){
        Column instance = new Column("nameTest", "typeTest", false);
        instance.setName("newName");
        assertEquals("newName", instance.getName());
    }

    @Test
    void setDataType(){
        Column instance = new Column("nameTest", "typeTest", false);
        instance.setDataType("newType");
        assertEquals("newType", instance.getDataType());
    }
}
