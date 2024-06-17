package hangman;

import java.util.UUID;

public class Account {
    private String passWord;
    private String userName;
    private UUID accountUUID;
    public  Account(String userName, String passWord) {
        this.accountUUID = UUID.randomUUID();
        this.passWord = HangMan.hash(passWord);
        this.userName = userName;

    }
    public boolean ValidPassWord(String passWord) {
        return HangMan.hash(passWord).equals(this.passWord);
    }
    public String getUserName() {
        return userName;
    }
    public UUID getAccountUUID() {
        return accountUUID;
    }
}
