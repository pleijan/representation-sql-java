package mainTest.queries.Tables;

import main.queries.Query;
import main.SQL;
import main.queries.Tables.*;
import mainTest.LifecycleLoggerTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SQLTest implements LifecycleLoggerTest {

    @Test
    void create() {
        SQL sql = new SQL();
        Query select = sql.create("select");
        assertEquals(select.getClass(),Select.class);

        Query drop = sql.create("drop");
        assertEquals(drop.getClass(),Drop.class);

        Query create = sql.create("create");
        assertEquals(create.getClass(), Create.class);

        Query insert = sql.create("insert");
        assertEquals(insert.getClass(), Insert.class);

        Query update = sql.create("update");
        assertEquals(update.getClass(), Update.class);
    }

}