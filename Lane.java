package sample;

import javafx.beans.property.SimpleStringProperty;

public class Lane {
    private final SimpleStringProperty lcName, Position1;

    Lane(String cName, String pos1){
        this.lcName = new SimpleStringProperty(cName);
        this.Position1 = new SimpleStringProperty(pos1);
    }

    public String getChampName() { return lcName.get(); }
    public void setChampName(String cName) {lcName.set(cName);}

    public String getPosition1() { return Position1.get(); }
    public void setPosition1(String pos1) {
        Position1.set(pos1);
    }
}
