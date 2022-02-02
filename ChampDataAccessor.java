package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChampDataAccessor {
    private final Connection connection;
    public final static String url = "jdbc:sqlite:C:/Users/noaha/IdeaProjects/Summoners List/SummonersList.db";

    public ChampDataAccessor(String url) throws SQLException {
        connection = DriverManager.getConnection(url);
    }

    //General Use
    public ArrayList<String> getChampionObvList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select Name from champions")
        ) {
            ArrayList<String> championList = new ArrayList<>();
            while (rs.next()) {
                String champName = rs.getString("Name");
                championList.add(champName);
            }
            return championList;
        }
    }

    public ArrayList<String> getSkinArrayList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select Name from skin")
        ) {
            ArrayList<String> skinList = new ArrayList<>();
            while (rs.next()) {
                String champName = rs.getString("Name");
                skinList.add(champName);
            }
            return skinList;
        }
    }

    //Update Tables
    public List<Champion> getChampionList() throws SQLException {
        try (
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from champions")
        ) {
            List<Champion> championList = new ArrayList<>();
            while (rs.next()) {
                String champName = rs.getString("Name");
                String DamageType = rs.getString("DamageType");
                int SkinNumber = rs.getInt("SkinNumber");
                String ReleaseDate = rs.getString("ReleaseDate");
                int BEPrice = rs.getInt("BEPrice");
                int RPPrice = rs.getInt("RPPrice");
                Champion champion = new Champion(champName, DamageType, SkinNumber, ReleaseDate, BEPrice, RPPrice);
                championList.add(champion);
            }
            return championList;
        }
    }

    public List<Skin> getSkinList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("SELECT champions.Name AS champName, skin.Name AS skinName, skin.SkinTheme, skin.Tier, skin.OEPrice, skin.RPPrice, skin.Gemstones, skin.Unlockable FROM skin JOIN champions ON skin.CID=champions.CID")
        ){
            List<Skin> skinList = new ArrayList<>();
            while (rs.next()) {
                String sChampName = rs.getString("champName");
                String skinName = rs.getString("skinName");
                String skinTheme = rs.getString("SkinTheme");
                String Tier = rs.getString("Tier");
                int OEPrice = rs.getInt("OEPrice");
                int SRPPrice = rs.getInt("RPPrice");
                int Gemstones = rs.getInt("Gemstones");
                int Unlockable = rs.getInt("Unlockable");
                Skin skin = new Skin(sChampName, skinName, skinTheme, Tier, OEPrice, SRPPrice, Gemstones, Unlockable);
                skinList.add(skin);
            }
            return skinList;
        }
    }

    public List<Class> getRoleList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("SELECT champions.Name, role.Class from role JOIN champions ON role.CID=champions.CID")
        ){
            List<Class> roleList = new ArrayList<>();
            while (rs.next()) {
                String rChampName = rs.getString("Name");
                String role = rs.getString("Class");
                Class role1 = new Class(rChampName, role);
                roleList.add(role1);
            }
            return roleList;
        }
    }

    public List<Lane> getLaneList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("SELECT champions.Name, lane.Position from lane JOIN champions ON lane.CID=champions.CID")
        ){
            List<Lane> laneList = new ArrayList<>();
            while (rs.next()) {
                String lChampName = rs.getString("Name");
                String pos = rs.getString("Position");
                Lane pos1 = new Lane(lChampName, pos);
                laneList.add(pos1);
            }
            return laneList;
        }
    }

    public List<Abilities> getAbilityList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select champions.Name, abilities.Q, abilities.W, abilities.E, abilities.R, abilities.Passive from abilities JOIN champions on abilities.CID=champions.CID")
        ) {
            List<Abilities> abilityList = new ArrayList<>();
            while (rs.next()) {
                String champName = rs.getString("Name");
                String q = rs.getString("Q");
                String w = rs.getString("W");
                String e = rs.getString("E");
                String r = rs.getString("R");
                String passive = rs.getString("passive");
                Abilities champion = new Abilities(champName, q, w, e, r, passive);
                abilityList.add(champion);
            }
            return abilityList;
        }
    }


    //Add to Database
    public void addChampion(String champName, String damageType, int skinNumber, String date, int bePrice, int rpPrice) {
        try{
            System.out.println("Inserting...");
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT CID FROM champions ORDER BY CID DESC LIMIT 1");
            int CID = rs.getInt("CID")+1;
            String query = "INSERT INTO champions VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, CID);
            preparedStmt.setString (2, champName);
            preparedStmt.setString (3, damageType);
            preparedStmt.setInt (4, skinNumber);
            preparedStmt.setString (5, date);
            preparedStmt.setInt (6, bePrice);
            preparedStmt.setInt (7, rpPrice);
            preparedStmt.execute();
            System.out.println("Inserted records into the table...");
        }
        catch (SQLException ignored){
        }
    }

    public void addAbility(String q, String w, String e, String r, String passive){
        try{
            System.out.println("Inserting...");
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT CID FROM champions ORDER BY CID DESC LIMIT 1");
            int CID = rs.getInt("CID")+1;
            String query = "INSERT INTO abilities VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, CID);
            preparedStmt.setString (2, q);
            preparedStmt.setString (3, w);
            preparedStmt.setString (4, e);
            preparedStmt.setString (5, r);
            preparedStmt.setString (6, passive);
            preparedStmt.execute();
            System.out.println("Inserted records into the table...");
        }
        catch (SQLException ignored){
        }
    }

    public void addRole(String role) {
        try{
            System.out.println("Inserting...");
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT CID FROM champions ORDER BY CID DESC LIMIT 1");
            int CID = rs.getInt("CID")+1;
            Statement stmnt1 = connection.createStatement();
            ResultSet rs1 = stmnt1.executeQuery("SELECT RID FROM role ORDER BY RID DESC LIMIT 1");
            int RID = rs1.getInt("RID")+1;
            String query = "INSERT INTO role VALUES(?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, CID);
            preparedStmt.setInt (2, RID);
            preparedStmt.setString (3, role);
            preparedStmt.execute();
            System.out.println("Inserted records into the table...");
        }
        catch (SQLException ignored){
        }
    }

    public void addLane(String position) {
        try{
            System.out.println("Inserting...");
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT CID FROM champions ORDER BY CID DESC LIMIT 1");
            int CID = rs.getInt("CID")+1;
            Statement stmnt1 = connection.createStatement();
            ResultSet rs1 = stmnt1.executeQuery("SELECT PID FROM lane ORDER BY PID DESC LIMIT 1");
            int PID = rs1.getInt("PID")+1;
            String query = "INSERT INTO lane VALUES(?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, CID);
            preparedStmt.setInt (2, PID);
            preparedStmt.setString (3, position);
            preparedStmt.execute();
            System.out.println("Inserted records into the table...");
        }
        catch (SQLException ignored){
        }
    }

    public void addSkin(String champName, String skinName, String theme, String tier, int oePrice, int rpPrice, int gems, int unlock) {
        try{
            System.out.println("Inserting...");
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT SID FROM skin ORDER BY SID DESC LIMIT 1");
            int SID = rs.getInt("SID")+1;
            String findCID = "SELECT CID FROM champions where Name=?";
            PreparedStatement getCID = connection.prepareStatement(findCID);
            getCID.setString(1, champName);
            ResultSet rs1 = getCID.executeQuery();
            int CID = rs1.getInt("CID");
            String query = "INSERT INTO skin VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, SID);
            preparedStmt.setInt (2, CID);
            preparedStmt.setString (3, skinName);
            preparedStmt.setString (4, theme);
            preparedStmt.setString (5, tier);
            preparedStmt.setInt (6, oePrice);
            preparedStmt.setInt (7, rpPrice);
            preparedStmt.setInt (8, gems);
            preparedStmt.setInt(9, unlock);
            preparedStmt.execute();
            System.out.println("Inserted records into the table...");
        }
        catch (SQLException ignored){
        }
    }

    //Remove from Database
    public void rmChampion(String champName) throws SQLException { //Cascade delete stopped working???????

        System.out.println("Removing...");

        String findCID = "SELECT CID FROM champions where Name=?";
        PreparedStatement getCID = connection.prepareStatement(findCID);
        getCID.setString(1, champName);
        ResultSet rs1 = getCID.executeQuery();
        int CID = rs1.getInt("CID");

        String query = "DELETE FROM champions WHERE CID=?";
        String query1 = "DELETE FROM skin WHERE CID=?";
        String query2 = "DELETE FROM abilities WHERE CID=?";
        String query3 = "DELETE FROM role WHERE CID=?";
        String query4 = "DELETE FROM lane WHERE CID=?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        PreparedStatement preparedStmt1 = connection.prepareStatement(query1);
        PreparedStatement preparedStmt2 = connection.prepareStatement(query2);
        PreparedStatement preparedStmt3 = connection.prepareStatement(query3);
        PreparedStatement preparedStmt4 = connection.prepareStatement(query4);
        preparedStmt.setInt (1, CID);
        preparedStmt1.setInt (1, CID);
        preparedStmt2.setInt (1, CID);
        preparedStmt3.setInt (1, CID);
        preparedStmt4.setInt (1, CID);
        preparedStmt.execute();
        preparedStmt1.execute();
        preparedStmt2.execute();
        preparedStmt2.execute();
        preparedStmt3.execute();
        preparedStmt4.execute();
        System.out.println("Removed records from the table...");
    }

    public void rmSkin(String skinName) throws SQLException {
        System.out.println("Removing...");
        String query = "DELETE FROM skin WHERE Name=?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString (1, skinName);
        preparedStmt.execute();
        System.out.println("Removed records from the table...");
    }

    //Update Database
    public void updChampion(String champName, String damageType, int skinNumber, String date, int bePrice, int rpPrice) {
        try{
            System.out.println("Updating...");
            String query = "UPDATE champions" + " SET DamageType = ?, SkinNumber = ?, ReleaseDate = ?, BEPrice = ?, RPPrice = ?" + "WHERE Name = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, damageType);
            preparedStmt.setInt (2, skinNumber);
            preparedStmt.setString (3, date);
            preparedStmt.setInt (4, bePrice);
            preparedStmt.setInt (5, rpPrice);
            preparedStmt.setString(6, champName);
            preparedStmt.execute();
            System.out.println("Updated records in the table...");
        }
        catch (SQLException ignored){
        }
    }
    public void updSkin(String oldName, String Name, String skinTheme, String Tier, int OEPrice, int RPPrice, int Gemstones, int Unlockable) {
        try{
            System.out.println("Updating...");
            String findSID = "Select SID from skin WHERE Name=?";
            PreparedStatement getSID = connection.prepareStatement(findSID);
            getSID.setString(1, oldName);
            ResultSet rs = getSID.executeQuery();
            int SID = rs.getInt("SID");

            String query = "UPDATE skin" + " SET SkinTheme = ?, Name = ?, Tier = ?, OEPrice = ?, RPPrice = ?, GemStones = ?, Unlockable = ?" + "WHERE SID = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, skinTheme);
            preparedStmt.setString (2, Name);
            preparedStmt.setString (3, Tier);
            preparedStmt.setInt (4, OEPrice);
            preparedStmt.setInt (5, RPPrice);
            preparedStmt.setInt (6, Gemstones);
            preparedStmt.setInt(7, Unlockable);
            preparedStmt.setInt(8,SID);
            preparedStmt.execute();
            System.out.println("Updated records in the table...");
        }
        catch (SQLException ignored){
        }
    }

    public void updAbility(String champName, String q, String w, String e, String r, String passive) {
        try{
            System.out.println("Updating...");
            String findCID = "Select CID FROM champions WHERE Name=?";
            PreparedStatement getCID = connection.prepareStatement(findCID);
            getCID.setString(1, champName);
            ResultSet rs = getCID.executeQuery();
            int CID = rs.getInt("CID");

            String query = "UPDATE abilities" + " SET Q = ?, W = ?, E = ?, R = ?, Passive = ?" + "WHERE CID = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, q);
            preparedStmt.setString (2, w);
            preparedStmt.setString (3, e);
            preparedStmt.setString (4, r);
            preparedStmt.setString (5, passive);
            preparedStmt.setInt(6, CID);
            preparedStmt.execute();
            System.out.println("Updated records in the table...");
        }
        catch (SQLException ignored){
        }
    }

    public void updRole(String champName, String role, boolean second) {
        try{
            System.out.println("Updating...");
            String findCID = "Select CID FROM champions WHERE Name=?";
            PreparedStatement getCID = connection.prepareStatement(findCID);
            getCID.setString(1, champName);
            ResultSet rs = getCID.executeQuery();
            int CID = rs.getInt("CID");

            String findRID = "Select RID FROM role WHERE CID=? ORDER BY RID LIMIT 1";
            PreparedStatement getRID = connection.prepareStatement(findRID);
            getRID.setInt(1, CID);
            ResultSet rs1 = getRID.executeQuery();
            int RID = rs1.getInt("RID");
            if (second)
                RID++;
            String query = "UPDATE role" + " SET CID = ?, Class = ?" + "WHERE RID = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, CID);
            preparedStmt.setString (2, role);
            preparedStmt.setInt (3, RID);
            preparedStmt.execute();
            System.out.println("Updated records in the table...");
        }
        catch (SQLException ignored){
        }
    }


    public void updLane(String champName, String position, boolean second) {
        try{
            System.out.println("Updating...");
            String findCID = "Select CID FROM champions WHERE Name=?";
            PreparedStatement getCID = connection.prepareStatement(findCID);
            getCID.setString(1, champName);
            ResultSet rs = getCID.executeQuery();
            int CID = rs.getInt("CID");

            String findPID = "Select PID FROM lane WHERE CID=? ORDER BY PID LIMIT 1";
            PreparedStatement getPID = connection.prepareStatement(findPID);
            getPID.setInt(1, CID);
            ResultSet rs1 = getPID.executeQuery();
            int PID = rs1.getInt("PID");
            if (second)
                PID++;
            String query = "UPDATE lane" + " SET CID = ?, Position = ?" + "WHERE PID = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, CID);
            preparedStmt.setString (2, position);
            preparedStmt.setInt (3, PID);
            preparedStmt.execute();
            System.out.println("Updated records in the table...");
        }
        catch (SQLException ignored){
        }
    }

}
