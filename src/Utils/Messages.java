package Utils;

public enum Messages {

    CONNECTCLIENT1((String) "1"),
    CONNECTCLIENT2((String) "2"),

    CONNECTSERVER((String) "3"),
    FINISH((String) "4");


    private final String value;

    Messages(String value){
        this.value = value;
    }

    public String getValue(){
        return  value;
    }

    public String getValueString() {
        return  String.valueOf(value);
    }

}
