package main;

public class Column {
    private String name;
    private String dataType;
    private boolean nullable;

    public Column(String name, String dataType, boolean nullable)
    {
        this.name = name;
        this.dataType = dataType;
        this.nullable = nullable;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDataType(){
        return dataType;
    }

    public void setDataType(String dataType){
        this.dataType = dataType;
    }

    public String getNullable(){
        if (nullable) return "NULL";
        else return " NOT NULL";
    }
}
