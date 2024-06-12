package hangman;
import java.sql.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Use JDBC to connect to your database and run queries

public class DatabaseManager {
    private static final String url = "jdbc:postgresql://localhost:5432/HangMan";
    private static final String username = "postgres";
    private static final String password = "1384";
    private static Connection connection;
    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("vasl shod");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(url, username, password);
    }
    public static void newUser(String name, String username, String password) {
        try (Connection connection2 = connect()) {
            String query = "INSERT INTO userinfo (name, username, password) VALUES (?, ?, ?)";
            PreparedStatement ps = connection2.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void newGame(Game game) {
        try (Connection connection2 = connect()) {
            String query = "INSERT INTO gameinfo (gameid, username, word, wrongguesses, time, win) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection2.prepareStatement(query);
            ps.setObject(1, game.getGameId());
            ps.setString(2, game.getUsername());
            ps.setString(3, game.getWord());
            ps.setInt(4, game.getWrongGuesses());
            ps.setInt(5, game.getTime());
            ps.setBoolean(6, game.isWin());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static User getUser(String username) throws SQLException {
        Connection connection2 = connect();
        String query = "SELECT * FROM userinfo WHERE username = ?";
        PreparedStatement ps = connection2.prepareStatement(query);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        connection2.close();
        if (rs.next()) {
            User user = new User(rs.getString("name"), rs.getString("username"), rs.getString("password"), 0);
            return user;
        }
        return null;
    }
    public static boolean validUsername(String username) throws SQLException {
        User user = getUser(username);
        if (user == null)
            return true;
        return false;
    }
    public static boolean validLogin(String username, String password) throws SQLException {
        User user = getUser(username);
        if (user == null) {
            return false;
        }
        return HangMan.hash(password).equals(user.getPassword());
    }
    public static List<User> getUsers() throws SQLException {
        Connection connection2 = connect();
        String query = "SELECT * FROM gameinfo";
        PreparedStatement ps = connection2.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        connection2.close();
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User(rs.getString(""), rs.getString("username"), rs.getString(""), 0);
            boolean h = false;
            int loc = 0;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(user.getUsername())) {
                    h = true;
                    loc = i;
                }
            }
            if (h) {
                user = users.get(loc);
                if (rs.getBoolean("win")) {
                    user.setNumberOfWin(user.getNumberOfWin() + 1);
                }
                users.set(loc, user);
            }
            else {
                if (rs.getBoolean("win")) {
                    user.setNumberOfWin(user.getNumberOfWin() + 1);
                    users.add(user);
                }
            }
        }
        return users;
    }
    public static List<Game> getGameInfo(String username) throws SQLException {
        List<Game> games = new ArrayList<>();
        Connection connection2 = connect();
        String query = "SELECT * FROM gameinfo WHERE username = ?";
        PreparedStatement ps = connection2.prepareStatement(query);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        connection2.close();
        while (rs.next()) {
            Game game = new Game(username, rs.getString("word"));
            game.setTime(rs.getInt("time"));
            game.setWin(rs.getBoolean("win"));
            game.setWord(rs.getString("word"));
            games.add(game);
        }
        return games;
    }
    public static void main(String[] args) throws SQLException {
    }

}