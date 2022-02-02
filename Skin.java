package sample;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Skin {
    private final SimpleStringProperty  sChampName, skinName, skinTheme, Tier;
    private final SimpleIntegerProperty OEPrice, SRPPrice, Gemstones, Unlockable;

    Skin(String scName, String sName, String sTheme, String tier, int OePrice, int RpPrice, int gemstones, int unlockable){
        this.sChampName = new SimpleStringProperty(scName);
        this.skinName = new SimpleStringProperty(sName);
        this.skinTheme = new SimpleStringProperty(sTheme);
        this.Tier = new SimpleStringProperty(tier);
        this.OEPrice = new SimpleIntegerProperty(OePrice);
        this.SRPPrice = new SimpleIntegerProperty(RpPrice);
        this.Gemstones = new SimpleIntegerProperty(gemstones);
        this.Unlockable = new SimpleIntegerProperty(unlockable);
    }

    public String getChampName() { return sChampName.get(); }
    public void setChampName(String scName){ sChampName.set(scName);}

    public String getSkinName() {
        return skinName.get();
    }
    public void setSkinName(String sName) {
        skinName.set(sName);
    }

    public String getSkinTheme() { return skinTheme.get(); }
    public void setSkinTheme(String sTheme) {
        skinTheme.set(sTheme);
    }

    public String getTier() { return Tier.get(); }
    public void setTier(String tier) {
        Tier.set(tier);
    }

    public int getOEPrice() { return OEPrice.get(); }
    public void setOEPrice(int OePrice) {
        OEPrice.set(OePrice);
    }

    public int getSRPPrice() { return SRPPrice.get(); }
    public void setSRPPrice(int SRpPrice) {
        SRPPrice.set(SRpPrice);
    }

    public int getGemstones() { return Gemstones.get(); }
    public void setGemStones(int gemstones) {
        Gemstones.set(gemstones);
    }

    public int getUnlockable() { return Unlockable.get(); }
    public void setUnlockable(int unlockable) {
        Unlockable.set(unlockable);
    }
}
