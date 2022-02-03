import java.util.ArrayList;

public class Table {

    private ArrayList<String> elements;
    private String name;


    public void Table(String nameTable){
        name = nameTable;
        elements = new ArrayList<String>();
    }

    public void Table(String nameTable,String[] initElements){
        name = nameTable;
        elements = new ArrayList<String>();
        for(int i=0; i<initElements.length; i++){
            elements.add(initElements[i]);
        }
    }

    public void addElement(String newElement){
        elements.add(newElement);
    }

    public void addElement(String[] newElements){
        for(int i=0; i<newElements.length; i++){
            elements.add(newElements[i]);
        }
    }

    public void removeElement(String toRemove){
        if (!elements.remove(toRemove)) {
            System.err.println(
                    "Tentative de retrait un objet non contenu dans la liste");
        }
    }

    public String getName(){
        return name;
    }

}
