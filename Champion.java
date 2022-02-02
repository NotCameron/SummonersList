package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Champion {
    private final SimpleStringProperty champName, DamageType, ReleaseDate;
    private final SimpleIntegerProperty SkinNumber, BEPrice, RPPrice;

    Champion(String cName, String DType, int SNumber, String RDate, int BePrice, int RpPrice){
        this.champName = new SimpleStringProperty(cName);
        this.DamageType = new SimpleStringProperty(DType);
        this.SkinNumber = new SimpleIntegerProperty(SNumber);
        this.ReleaseDate = new SimpleStringProperty(RDate);
        this.BEPrice = new SimpleIntegerProperty(BePrice);
        this.RPPrice = new SimpleIntegerProperty(RpPrice);
    }

    public String getChampName() {
        return champName.get();
    }
    public void setChampName(String cName) {
        champName.set(cName);
    }

    public String getDamageType() {
        return DamageType.get();
    }
    public void setLastName(String fName) {
        DamageType.set(fName);
    }

    public int getSkinNumber() { return SkinNumber.get(); }
    public void setSkinNumber(int SNumber) {
        SkinNumber.set(SNumber);
    }

    public String getReleaseDate() { return ReleaseDate.get(); }
    public void setReleaseDate(String RDate) {
        ReleaseDate.set(RDate);
    }

    public int getBEPrice() { return BEPrice.get(); }
    public void setBEPrice(int BePrice) {
        BEPrice.set(BePrice);
    }

    public int getRPPrice() { return RPPrice.get(); }
    public void setRPPrice(int RpPrice) {
        RPPrice.set(RpPrice);
    }

}
