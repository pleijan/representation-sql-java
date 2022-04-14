package main.queries.Tables;

import main.queries.Query;
import java.util.ArrayList;
import java.util.Iterator;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.replace;

/**
 * This class reproduces the action of the UPDATE method in SQL, it is used to update values from a table
 */

public class Update extends Query {

    private ArrayList<String> newValue;


    /**
     * default constructor for update
     */
    public Update(){
        super();
        newValue = new ArrayList<String>();
    }


    /**
     * Add an attribute to update
     * @param _attribute column o change
     * @param newVal newVal of the col
     */
    public void update(String _attribute, String newVal) {
        this.attributes.add(_attribute);
        newValue.add(newVal);
    }


    /**
     * function who concatenate 2 Arraylist in the form of "nameCol = Values"
     * @return List of string
     */
    private ArrayList<String> colEqualsVal(){

        ArrayList<String> list = new ArrayList<String>();

        Iterator<String> colIter = this.attributes.iterator();
        Iterator<String> valIter = newValue.iterator();

        while(colIter.hasNext()){
            list.add(colIter.next()+" = "+valIter.next()+",");
        }

        String replace = list.get(list.size()-1).replace(",","");
        list.remove(list.size()-1);
        list.add(replace);

        return list;
    }

    @Override
    public String printQuery() {
        String query="";
        query+= "UPDATE "+getTableName()+ " SET " + listAsString(colEqualsVal())  ;

        // Add WHERE Conditions
        if(this.wheres.size() > 0){
            query += " "+listAsString(this.wheres," AND ");
        }
        return query+=";";
    }

    public ArrayList<String> getNewValue() {
        return newValue;
    }
}
