package sample;

import javafx.beans.property.SimpleStringProperty;

public class Abilities {
    private final SimpleStringProperty aChampName, qAbl, wAbl, eAbl, rAbl, passiveAbl;

    Abilities(String cName, String q, String w, String e, String r, String passive){
        this.aChampName = new SimpleStringProperty(cName);
        this.qAbl = new SimpleStringProperty(q);
        this.wAbl = new SimpleStringProperty(w);
        this.eAbl = new SimpleStringProperty(e);
        this.rAbl = new SimpleStringProperty(r);
        this.passiveAbl = new SimpleStringProperty(passive);
    }

    public String getChampName() {
        return aChampName.get();
    }
    public void setChampName(String cName) {
        aChampName.set(cName);
    }

    public String getQAbl() {
        return qAbl.get();
    }
    public void setQAbl(String q) {
        qAbl.set(q);
    }

    public String getWAbl() {
        return wAbl.get();
    }
    public void setWAbl(String w) {
        wAbl.set(w);
    }

    public String getEAbl() {
        return eAbl.get();
    }
    public void setEAbl(String e) {
        eAbl.set(e);
    }

    public String getRAbl() {
        return rAbl.get();
    }
    public void setRAbl(String r) {
        rAbl.set(r);
    }

    public String getPassiveAbl() {
        return passiveAbl.get();
    }
    public void setPassiveAbl(String passive) {
        passiveAbl.set(passive);
    }
}
