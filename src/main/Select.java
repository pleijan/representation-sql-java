package main;

public class Select {

    public Elements elements;
    public String from;
    public String where;
    public String group;
    public String order;

    public Select(Elements elements, String from, String where, String group, String order){
        this.elements = elements;
        this.from = from;
        this.where = where;
        this.group = group;
        this.order = order;
    }

    @Override
    public String toString() {
        return "SELECT " + elements + " " + from + " " + where + " " + group + " " + order;
    }
}
