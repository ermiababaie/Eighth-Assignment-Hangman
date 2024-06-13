package hangman;

public class User {
    private String Name;
    private String Username;
    private String Password;
    private int numberOfWin;
    public User(String Name, String Username, String password, int numberOfWin) {
        this.Name = Name;
        this.Username = Username;
        this.Password = HangMan.hash(password);
        this.numberOfWin = numberOfWin;
    }

    public String getName() {
        return Name;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public int getNumberOfWin() {
        return numberOfWin;
    }

    public void setNumberOfWin(int numberOfWin) {
        this.numberOfWin = numberOfWin;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
