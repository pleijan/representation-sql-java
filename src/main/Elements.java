package main;

public class Elements {
    String elements[];

    public Elements(String elements[]){
        this.elements = elements;
    }

    @Override
    public String toString() {
        String retour = "";
        for (int i = 0; i<elements.length; i++){
            retour += elements[i] + ", ";
        }

        return retour;
    }
}
