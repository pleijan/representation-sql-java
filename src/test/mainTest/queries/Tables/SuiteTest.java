package mainTest.queries.Tables;

/**
 * This class executes all test methods
 */

public class SuiteTest {
    public static void main(String[] args) {


        /** CreateTest class */

        CreateTest createTest = new CreateTest();

        createTest.CreateTable();
        createTest.CreateDatabase();
        createTest.printQueryTable();
        createTest.printQueryDatabase();

        /** DropTest class */

        DropTest dropTest = new DropTest();

        dropTest.from();
        dropTest.printQuery();

        /** InsertTest class */

        InsertTest insertTest =new InsertTest();

        insertTest.from();
        insertTest.insert();
        insertTest.testInsert();
        insertTest.printQuery();

        /** SelectTest class */

        SelectTest selectTest = new SelectTest();

        selectTest.select();
        selectTest.selectDistinct();
        selectTest.selectUnique();
        selectTest.where();
        selectTest.from();
        selectTest.join();
        selectTest.groupBy();
        selectTest.orderBy();
        selectTest.printQuery();

        /** UpdateTest class */

        UpdateTest updateTest = new UpdateTest();

        updateTest.from();
        updateTest.update();
        updateTest.printQuery();

        /** DatabaseTest class */

        DatabaseTest databaseTest = new DatabaseTest();

        databaseTest.database();
        databaseTest.addTable();

        /** TableTest class */

        TableTest tableTest = new TableTest();

        tableTest.Table();
        tableTest.addElement();
        tableTest.testAddElement();
        tableTest.removeElement();

        /** Delete class */

        DeleteTest deleteTest = new DeleteTest();

        deleteTest.from();
        deleteTest.printQuery();
    }
}
