package main;

import java.util.ArrayList;

/**
 * This class represents a table in SQL, so it has a name and a list of elements
 */

public class Table {

    private ArrayList<String> elements;
    private String name;

    /**
     * constructor of the table class with no element
     * @param nameTable name of the table
     */
    public Table(String nameTable){
        name = nameTable;
        elements = new ArrayList<String>();
    }


    /**
     * function who add one element to the list "Elements"
     * @param newElement name of the new Element
     */
    public void addElement(String newElement){
        elements.add(newElement);
    }

    /**
     * function who add a list of elements to the list "Elements"
     * @param newElements list of New Elements
     */
    public void addElement(String[] newElements){
        for(int i=0; i<newElements.length; i++){
            elements.add(newElements[i]);
        }
    }

    /**
     * function who remove one element from the list "Elements"
     * @param toRemove the Element to remove
     */
    public void removeElement(String toRemove){
        if (!elements.remove(toRemove)) {
            System.err.println(
                    "Tentative de retrait un objet non contenu dans la liste.");
        }
    }

    /**
     * function who return the name of the table
     * @return the name of the table
     */
    public String getName(){
        return name;
    }

    /**
     * Getter of Elements
     * @return the list of Elements
     */
    public ArrayList<String> getElements() {
        return elements;
    }

    /**
     * Method to get the element with the name of the table
     * @param _toGet the element
     * @return "tableName.element" if the element is in the list, or "" and an error;
     */
    public String get(String _toGet) {
        String res = "";
        if(this.elements.contains(_toGet)){
            res = this.name + "." + _toGet;
        } else {
            System.err.println("Cet attribut ne fait pas partie de cette table.");
        }
        return res;
    }
}
