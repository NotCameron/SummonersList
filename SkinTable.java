package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SkinTable {
        @FXML
        private ComboBox chdp, rmdp, ch;

        @FXML
        private TextField sknm, skt, tier, oep, rpp, nsknm, skt2, tier2, oep2, rp2;

        @FXML
        private CheckBox gem, unl, gem2, unl2;

        @FXML
        private Button upd, add, rm;
        public void initialize() throws SQLException {
                ChampDataAccessor dataAccessor = new ChampDataAccessor(ChampDataAccessor.url);
                ObservableList<String> skins = FXCollections.observableArrayList(dataAccessor.getSkinArrayList());
                ObservableList<String> champions = FXCollections.observableArrayList(dataAccessor.getChampionObvList());
                chdp.setItems(skins);
                rmdp.setItems(skins);
                ch.setItems(champions);
        }

        @FXML
        void updateAction() throws SQLException {
                ChampDataAccessor dataAccessor = new ChampDataAccessor(ChampDataAccessor.url);

                if (chdp.getValue() != ""){
                        String oldSkinName = chdp.getValue().toString();
                        String skinName = sknm.getText();
                        String skinTheme = skt.getText();
                        String Tier = tier.getText();
                        int RPPrice = Integer.parseInt(rpp.getText());
                        int OEPrice = Integer.parseInt(oep.getText());
                        int Gemstones;
                        if (gem.isSelected())
                                Gemstones = 1;
                        else
                                Gemstones = 0;
                        int Unlockable;
                        if (unl.isSelected())
                                Unlockable = 1;
                        else
                                Unlockable = 0;
                        dataAccessor.updSkin(oldSkinName, skinName, skinTheme, Tier, OEPrice, RPPrice, Gemstones, Unlockable);
                }

                Stage stage = (Stage) upd.getScene().getWindow();
                stage.close();
        }
        @FXML
        void addAction() throws SQLException {
                ChampDataAccessor dataAccessor = new ChampDataAccessor(ChampDataAccessor.url);
                if (chdp.getValue() != "") {
                        String champName = ch.getValue().toString();
                        String skinName = nsknm.getText();
                        String theme = skt2.getText();
                        String skintier = tier2.getText();
                        int oePrice = Integer.parseInt(oep2.getText());
                        int rpPrice = Integer.parseInt(rp2.getText());
                        int gemstones;
                        if (gem2.isSelected())
                                gemstones = 1;
                        else
                                gemstones = 0;
                        int unlockable;
                        if (unl2.isSelected())
                                unlockable = 1;
                        else
                                unlockable = 0;
                        dataAccessor.addSkin(champName, skinName, theme, skintier, oePrice, rpPrice, gemstones, unlockable);
                }

                Stage stage = (Stage) add.getScene().getWindow();
                stage.close();
        }
        @FXML
        void removeAction() throws SQLException {
                ChampDataAccessor dataAccessor = new ChampDataAccessor(ChampDataAccessor.url);

                if (rmdp.getValue() != ""){
                        String skinName = rmdp.getValue().toString();
                        dataAccessor.rmSkin(skinName);
                }
                Stage stage = (Stage) rm.getScene().getWindow();
                stage.close();
        }

        public static void display() throws IOException{
                Parent root = FXMLLoader.load(Skin.class.getResource("EditS.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Update Skin-related Tables");
                stage.setScene(new Scene(root));
                stage.showAndWait();
        }

        }
