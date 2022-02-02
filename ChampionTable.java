package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ChampionTable {

    @FXML
    public ComboBox chDp, rmDp;

    @FXML
    private TextField dt, role, lane, sk, rd, bep, rpp, pas, qab, wab, eab, rab, role2, lane2, nch, ndt, nrole, nlane, nsk, nrd, nbp, nrp, npass, nqab, nwab, neab, nrab, nrole2, nlane2;

    @FXML
    private Button update, addnew, rm;

    public void initialize() throws SQLException {
        ChampDataAccessor dataAccessor = new ChampDataAccessor(ChampDataAccessor.url);
        ObservableList<String> champs = FXCollections.observableArrayList(dataAccessor.getChampionObvList());
        chDp.setItems(champs);
        rmDp.setItems(champs);
    }

    @FXML
    void updateAction() throws SQLException {
        ChampDataAccessor dataAccessor = new ChampDataAccessor(ChampDataAccessor.url);
        if (chDp.getValue() != ""){
            String champName = chDp.getValue().toString();
            String damageType = dt.getText();
            String nrole1 = role.getText();
            String nrole2 = role2.getText();
            String nlane1 = lane.getText();
            String nlane2 = lane2.getText();
            int skinNumber = Integer.parseInt(sk.getText());
            String releaseDate = rd.getText();
            int bePrice = Integer.parseInt(bep.getText());
            int rpPrice = Integer.parseInt(rpp.getText());
            String passive = pas.getText();
            String q = qab.getText();
            String w = wab.getText();
            String e = eab.getText();
            String r = rab.getText();

            //Update Tables
            dataAccessor.updAbility(champName, q, w, e, r, passive);
            dataAccessor.updRole(champName, nrole1, false);
            if (!nrole2.equals(""))
                dataAccessor.updRole(champName, nrole2, true);
            dataAccessor.updLane(champName, nlane1, false);
            if (!nlane2.equals(""))
                dataAccessor.updLane(champName, nlane2, true);
            dataAccessor.updChampion(champName, damageType, skinNumber, releaseDate, bePrice, rpPrice);
        }
        Stage stage = (Stage) update.getScene().getWindow();
        stage.close();
    }
    @FXML
    void addAction() throws SQLException {
        ChampDataAccessor dataAccessor = new ChampDataAccessor(ChampDataAccessor.url);

        String champName = nch.getText();
        String damageType = ndt.getText();
        String role1 = nrole.getText();
        String role2 = nrole2.getText();
        String lane1 = nlane.getText();
        String lane2 = nlane2.getText();
        int skinNumber = Integer.parseInt(nsk.getText());
        String releaseDate = nrd.getText();
        int bePrice = Integer.parseInt(nbp.getText());
        int rpPrice = Integer.parseInt(nrp.getText());
        String passive = npass.getText();
        String q = nqab.getText();
        String w = nwab.getText();
        String e = neab.getText();
        String r = nrab.getText();

        dataAccessor.addLane(lane1);
        if (!lane2.equals(""))
            dataAccessor.addLane(lane2);
        dataAccessor.addRole(role1);
        if (!role2.equals(""))
            dataAccessor.addRole(role2);
        dataAccessor.addAbility(q, w, e, r, passive);
        dataAccessor.addChampion(champName, damageType, skinNumber, releaseDate, bePrice, rpPrice);
        Stage stage = (Stage) addnew.getScene().getWindow();
        stage.close();
    }

    @FXML
    void removeAction() throws SQLException {
        ChampDataAccessor dataAccessor = new ChampDataAccessor(ChampDataAccessor.url);
        if (rmDp.getValue() != ""){
            String champName = rmDp.getValue().toString();
            dataAccessor.rmChampion(champName);
        }
        Stage stage = (Stage) rm.getScene().getWindow();
        stage.close();
    }

    public static void display() throws IOException{
        Parent root = FXMLLoader.load(ChampionTable.class.getResource("EditC.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Update Champion-related Tables");
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}
