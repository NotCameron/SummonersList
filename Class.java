package sample;

import javafx.beans.property.SimpleStringProperty;

public class Class {
    private final SimpleStringProperty rcName, Role1;

    Class(String cName, String role1){
        this.rcName = new SimpleStringProperty(cName);
        this.Role1 = new SimpleStringProperty(role1);
    }

    public String getChampName() {
        return rcName.get();
    }
    public void setChampName(String cName) {
        rcName.set(cName);
    }

    public String getRole1() { return Role1.get(); }
    public void setRole(String role1) {
        Role1.set(role1);
    }

}
