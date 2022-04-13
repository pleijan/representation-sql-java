package mainTest.queries.Tables;

import main.queries.Query;
import main.SQL;
import main.queries.Tables.*;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the class to test the selection of values with groups, order, joins and conditions
 */

class SQLTest implements LifecycleLoggerTest {

    @Test
    void create() {
        SQL sql = new SQL();
        Query select = sql.make("select");
        assertEquals(select.getClass(),Select.class);

        Query drop = sql.make("drop");
        assertEquals(drop.getClass(),Drop.class);

        Query create = sql.make("create");
        assertEquals(create.getClass(), Create.class);

        Query insert = sql.make("insert");
        assertEquals(insert.getClass(), Insert.class);

        Query update = sql.make("update");
        assertEquals(update.getClass(), Update.class);
    }

}