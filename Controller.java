package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    public ChampDataAccessor dataAccessor;

    @FXML
    public Button editCh, editSk;
    @FXML
    public ComboBox tbDp;
    @FXML
    public Label tbTt;
    @FXML
    public ScrollPane viewBox;

    @FXML
    public void champHandler() throws IOException {
        ChampionTable.display();
    }

    @FXML
    public void skinHandler() throws IOException {
        SkinTable.display();
    }

    public void initialize() {
        tbDp.getItems().addAll(
                "Champions",
                "Abilities",
                "Skin",
                "Lane",
                "Role"
        );

    }
    public void pickTable() throws SQLException {

        //Champion Table
        dataAccessor = new ChampDataAccessor(ChampDataAccessor.url);
        TableView<Champion> championTable = new TableView<>();
        championTable.setEditable(true);
        TableColumn<Champion, String> champName = new TableColumn<>("Name");
        champName.setCellValueFactory(new PropertyValueFactory<>("champName"));
        TableColumn<Champion, String> DamageType = new TableColumn<>("Damage Type");
        DamageType.setCellValueFactory(new PropertyValueFactory<>("DamageType"));
        TableColumn<Champion, Integer> SkinNumber = new TableColumn<>("Skin Number");
        SkinNumber.setCellValueFactory(new PropertyValueFactory<>("SkinNumber"));
        TableColumn<Champion, String> ReleaseDate = new TableColumn<>("Release Date");
        ReleaseDate.setCellValueFactory(new PropertyValueFactory<>("ReleaseDate"));
        TableColumn<Champion, Integer> BEPrice = new TableColumn<>("BE Price");
        BEPrice.setCellValueFactory(new PropertyValueFactory<>("BEPrice"));
        TableColumn<Champion, Integer> RPPrice = new TableColumn<>("RP Price");
        RPPrice.setCellValueFactory(new PropertyValueFactory<>("RPPrice"));

        championTable.getColumns().add(champName);
        champName.setPrefWidth(116);
        championTable.getColumns().add(DamageType);
        DamageType.setPrefWidth(116);
        championTable.getColumns().add(SkinNumber);
        SkinNumber.setPrefWidth(116);
        championTable.getColumns().add(ReleaseDate);
        ReleaseDate.setPrefWidth(116);
        championTable.getColumns().add(BEPrice);
        BEPrice.setPrefWidth(116);
        championTable.getColumns().add(RPPrice);
        RPPrice.setPrefWidth(116);
        championTable.getItems().addAll(dataAccessor.getChampionList());

        //Ability List
        TableView<Abilities> abilityTable = new TableView<>();
        abilityTable.setEditable(true);
        TableColumn<Abilities, String> AchampName = new TableColumn<>("Name");
        AchampName.setCellValueFactory(new PropertyValueFactory<>("champName"));
        TableColumn<Abilities, String> Q = new TableColumn<>("Q");
        Q.setCellValueFactory(new PropertyValueFactory<>("qAbl"));
        TableColumn<Abilities, String> W = new TableColumn<>("W");
        W.setCellValueFactory(new PropertyValueFactory<>("wAbl"));
        TableColumn<Abilities, String> E = new TableColumn<>("E");
        E.setCellValueFactory(new PropertyValueFactory<>("eAbl"));
        TableColumn<Abilities, String> R = new TableColumn<>("R");
        R.setCellValueFactory(new PropertyValueFactory<>("rAbl"));
        TableColumn<Abilities, String> Passive = new TableColumn<>("Passive");
        Passive.setCellValueFactory(new PropertyValueFactory<>("passiveAbl"));

        abilityTable.getColumns().add(AchampName);
        AchampName.setPrefWidth(116);
        abilityTable.getColumns().add(Q);
        Q.setPrefWidth(116);
        abilityTable.getColumns().add(W);
        W.setPrefWidth(116);
        abilityTable.getColumns().add(E);
        E.setPrefWidth(116);
        abilityTable.getColumns().add(R);
        R.setPrefWidth(116);
        abilityTable.getColumns().add(Passive);
        Passive.setPrefWidth(116);
        abilityTable.getItems().addAll(dataAccessor.getAbilityList());

        //Skin Table
        TableView<Skin> skinTable = new TableView<>();
        skinTable.setEditable(true);
        TableColumn<Skin, String> sChampName = new TableColumn<>("Name");
        sChampName.setCellValueFactory(new PropertyValueFactory<>("champName"));
        TableColumn<Skin, String> skinName = new TableColumn<>("Skin Name");
        skinName.setCellValueFactory(new PropertyValueFactory<>("skinName"));
        TableColumn<Skin, String> skinTheme = new TableColumn<>("Skin Theme");
        skinTheme.setCellValueFactory(new PropertyValueFactory<>("skinTheme"));
        TableColumn<Skin, String> Tier = new TableColumn<>("Tier");
        Tier.setCellValueFactory(new PropertyValueFactory<>("Tier"));
        TableColumn<Skin, Integer> OEPrice = new TableColumn<>("OEPrice");
        OEPrice.setCellValueFactory(new PropertyValueFactory<>("OEPrice"));
        TableColumn<Skin, Integer> SRPPrice = new TableColumn<>("RPPrice");
        SRPPrice.setCellValueFactory(new PropertyValueFactory<>("SRPPrice"));
        TableColumn<Skin, Integer> Gemstones = new TableColumn<>("Gemstones");
        Gemstones.setCellValueFactory(new PropertyValueFactory<>("Gemstones"));
        TableColumn<Skin, Integer> Unlockable = new TableColumn<>("Unlockable");
        Unlockable.setCellValueFactory(new PropertyValueFactory<>("Unlockable"));

        skinTable.getColumns().add(sChampName);
        sChampName.setPrefWidth(87);
        skinTable.getColumns().add(skinName);
        skinName.setPrefWidth(87);
        skinTable.getColumns().add(skinTheme);
        skinTheme.setPrefWidth(87);
        skinTable.getColumns().add(Tier);
        Tier.setPrefWidth(87);
        skinTable.getColumns().add(OEPrice);
        OEPrice.setPrefWidth(87);
        skinTable.getColumns().add(SRPPrice);
        SRPPrice.setPrefWidth(87);
        skinTable.getColumns().add(Gemstones);
        Gemstones.setPrefWidth(87);
        skinTable.getColumns().add(Unlockable);
        Unlockable.setPrefWidth(87);
        skinTable.getItems().addAll(dataAccessor.getSkinList());

        //Lane Table
        TableView<Lane> laneTable = new TableView<>();
        laneTable.setEditable(true);
        TableColumn<Lane, String> lcName = new TableColumn<>("Name");
        lcName.setCellValueFactory(new PropertyValueFactory<>("champName"));
        TableColumn<Lane, String> Position1 = new TableColumn<>("Position");
        Position1.setCellValueFactory(new PropertyValueFactory<>("Position1"));

        laneTable.getColumns().add(lcName);
        lcName.setPrefWidth(340);
        laneTable.getColumns().add(Position1);
        Position1.setPrefWidth(340);
        laneTable.getItems().addAll(dataAccessor.getLaneList());

        //Role Table
        TableView<Class> roleTable = new TableView<>();
        roleTable.setEditable(true);
        TableColumn<Class, String> rChampName = new TableColumn<>("Name");
        rChampName.setCellValueFactory(new PropertyValueFactory<>("champName"));
        TableColumn<Class, String> Role1 = new TableColumn<>("Role");
        Role1.setCellValueFactory(new PropertyValueFactory<>("Role1"));

        roleTable.getColumns().add(rChampName);
        rChampName.setPrefWidth(340);
        roleTable.getColumns().add(Role1);
        Role1.setPrefWidth(340);
        roleTable.getItems().addAll(dataAccessor.getRoleList());

        if (tbDp.getValue() == "Champions") {
            tbTt.setText("Champions");
            viewBox.setContent(championTable);
        } else if (tbDp.getValue() == "Abilities") {
            tbTt.setText("Abilities");
            viewBox.setContent(abilityTable);
        } else if (tbDp.getValue() == "Skin") {
            tbTt.setText("Skins");
            viewBox.setContent(skinTable);
        } else if (tbDp.getValue() == "Lane") {
            tbTt.setText("Lanes");
            viewBox.setContent(laneTable);
        } else if (tbDp.getValue() == "Role") {
            tbTt.setText("Classes");
            viewBox.setContent(roleTable);
        } else {
            tbTt.setText("Pick a table");
        }
    }
}

