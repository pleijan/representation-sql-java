import java.util.ArrayList;

public class Table {

    private ArrayList<String> elements;
    private String name;

    /**
     * constructor of the table class with no element
     * @param nameTable name of the table
     */
    public void Table(String nameTable){
        name = nameTable;
        elements = new ArrayList<String>();
    }


    /**
     * function who add one element to the list "Elements"
     * @param newElement
     */
    public void addElement(String newElement){
        elements.add(newElement);
    }

    /**
     * function who add a list of elements to the list "Elements"
     * @param newElements
     */
    public void addElement(String[] newElements){
        for(int i=0; i<newElements.length; i++){
            elements.add(newElements[i]);
        }
    }

    /**
     * function who remove one element from the list "Elements"
     * @param toRemove
     */
    public void removeElement(String toRemove){
        if (!elements.remove(toRemove)) {
            System.err.println(
                    "Tentative de retrait un objet non contenu dans la liste");
        }
    }

    /**
     * function who return the name of the table
     * @return the name of the table
     */
    public String getName(){
        return name;
    }

}
