package hangman;

import java.util.UUID;

public class Game {
    private String Username;
    private UUID GameId;
    private int Time;
    private String word;
    private int WrongGuesses;
    private boolean Win;
    public Game(String username, String Word) {
        this.Username = username;
        this.GameId = UUID.randomUUID();
        this.word = Word;
    }

    public void setTime(int time) {
        this.Time = time;
    }

    public void setWrongGuesses(int wrongGuesses) {
        this.WrongGuesses = wrongGuesses;
    }

    public void setWin(boolean win) {
        this.Win = win;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public UUID getGameId() {
        return GameId;
    }

    public int getTime() {
        return Time;
    }

    public boolean isWin() {
        return Win;
    }

    public int getWrongGuesses() {
        return WrongGuesses;
    }

    public String getWord() {
        return word;
    }

    public String getUsername() {
        return Username;
    }
}
