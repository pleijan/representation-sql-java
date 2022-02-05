package mainTest;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;



@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public interface LifecycleLoggerTest {

    static final Logger LOG = Logger.getLogger(LifecycleLoggerTest.class.getName());

    @BeforeAll
    default void setUp(TestInfo testInfo) {
        LOG.info("@BeforeAll - Testing "+testInfo.getTestClass().get().getName());
    }

    @AfterAll
    default void done(TestInfo testInfo) {
        LOG.info("@AfterAll - End Testing "+testInfo.getTestClass().get().getName());
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("About to execute [%s]",
                testInfo.getDisplayName())+ "\n");
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("Finished executing [%s]",
                testInfo.getDisplayName())+ "\n");
    }
}

