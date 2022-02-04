package main.queries.Tables;

import main.Table;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DropTest {
    private static final String name = "DropTest TABLE Class \n";
    static final Logger logger = Logger.getLogger(DropTest.class.getName());

    @BeforeAll
    static void setUp() {
        logger.info("@BeforeAll - Testing "+name);
    }

    @AfterAll
    static void done() {
        logger.info("@AfterAll - End Testing "+name);
    }

    @BeforeEach
    void beforeEachTest(TestInfo testInfo) {
        logger.info(() -> String.format("About to execute [%s]",
                testInfo.getDisplayName())+ "\n");
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo) {
        logger.info(() -> String.format("Finished executing [%s]",
                testInfo.getDisplayName())+ "\n");
    }

    @Test
    @DisplayName("from()- The table used in the query")
    void from() {
        String tableName = "TestTable";
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Drop instance = new Drop();
        instance.from(tableName); // Add the tableName to the query


        assertEquals(testTable.getName(),instance.tableName);
        assertNotEquals("",instance.tableName);
    }

    @Test
    @DisplayName("queryString()- The final step of the Class")
    void queryString() {
        String tableName = "TestTable";
        String stringQuery = "DROP TABLE "+ tableName;
        // Creation of the table
        Table testTable = new Table(tableName);

        // Creation of the query
        Drop instance = new Drop();
        instance.from(tableName); // Add the tableName to the query

        assertEquals(stringQuery,instance.queryString());

    }
}