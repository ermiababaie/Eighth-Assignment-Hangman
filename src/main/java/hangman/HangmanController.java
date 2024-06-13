package hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

public class HangmanController {
    int ft = 0;
    @FXML
    private ListView<String> GameInfoList = new ListView<String>();
    @FXML
    private ListView<String> leaderBoardList = new ListView<String>();
    @FXML
    private AnchorPane namePage;
    @FXML
    private TextField NameField;
    @FXML
    private Button enterName;
    @FXML
    private Label regError3;
    @FXML
    private AnchorPane leaderBoardPage;
    @FXML
    private Button backToStartPage;
    @FXML
    private AnchorPane gameInfoPage;
    @FXML
    private Button backToStartPage2;
    @FXML
    private AnchorPane regPage;
    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;
    @FXML
    private Button backToRegPage;
    @FXML
    private AnchorPane regPage2;
    @FXML
    private Button reg2Button;
    @FXML
    Label regError;
    @FXML
    private TextField userNameField;
    @FXML
    private TextField passWordField;
    @FXML
    private Button GoToMenu;
    @FXML
    private Label gameTime;
    @FXML
    private Label wrongGuess;
    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private AnchorPane GameOver;
    @FXML
    private AnchorPane startGame;
    @FXML
    private Button leaderBoard;
    @FXML
    private Button GameInfo;
    @FXML
    private Button startButton;
    @FXML
    private Label welcomeText;
    @FXML
    private Button aButton;
    @FXML
    private Button bButton;
    @FXML
    private Button cButton;
    @FXML
    private Button dButton;
    @FXML
    private Button eButton;
    @FXML
    private Button fButton;
    @FXML
    private Button gButton;
    @FXML
    private Button hButton;
    @FXML
    private Button iButton;
    @FXML
    private Button jButton;
    @FXML
    private Button kButton;
    @FXML
    private Button lButton;
    @FXML
    private Button mButton;
    @FXML
    private Button nButton;
    @FXML
    private Button oButton;
    @FXML
    private Button pButton;
    @FXML
    private Button qButton;
    @FXML
    private Button rButton;
    @FXML
    private Button sButton;
    @FXML
    private Button tButton;
    @FXML
    private Button uButton;
    @FXML
    private Button vButton;
    @FXML
    private Button wButton;
    @FXML
    private Button xButton;
    @FXML
    private Button yButton;
    @FXML
    private Button zButton;
    @FXML
    private Button letter1;
    @FXML
    private Button letter2;
    @FXML
    private Button letter3;
    @FXML
    private Button letter4;
    @FXML
    private Button letter5;
    @FXML
    private Button letter6;
    @FXML
    private Button letter7;
    @FXML
    private Button letter8;
    @FXML
    private Button letter9;
    @FXML
    private Button letter10;
    @FXML
    private Button letter11;
    @FXML
    private Button letter12;
    @FXML
    private Button letter13;
    @FXML
    private Button letter14;
    @FXML
    private Button letter15;
    @FXML
    private Button letter16;
    @FXML
    private Button letter17;
    @FXML
    private Button letter18;
    @FXML
    private Button letter19;
    @FXML
    private Button letter20;
    @FXML
    private ImageView hang1;
    @FXML
    private ImageView hang2;
    @FXML
    private ImageView hang3;
    @FXML
    private ImageView hang4;
    @FXML
    private ImageView head;
    @FXML
    private ImageView body;
    @FXML
    private ImageView leftHand;
    @FXML
    private ImageView rightHand;
    @FXML
    private ImageView leftFoot;
    @FXML
    private ImageView rightFoot;
    @FXML
    private static HBox downHbox;
    @FXML
    static List<ImageView> imageViewList = new ArrayList<>();
    List<Button> buttonList = new ArrayList<>();
    @FXML
    private String Mainword = "";
    private List<Button> lettersList = new ArrayList<>();
    int step = 0;
    int dis = 0;
    int mnl = 0;
    int cntLet = 0;
    LocalDateTime st, fn;
    Duration duration;
    User user = new User("", "", "", 0);
    Game game = new Game("","");
    @FXML
    protected void NameEntered() {
        if (NameField.getText().equals("")) {
            regError3.setText("                  name must be filled");
        }
        else {
            startGame.setVisible(true);
            namePage.setVisible(false);
            user.setName(NameField.getText());
            DatabaseManager.newUser(user.getName(), user.getUsername(), user.getPassword());
            regError3.setText("");
            NameField.clear();
        }
    }
    @FXML
    protected void BackToStartPage() {
        startGame.setVisible(true);
        leaderBoardPage.setVisible(false);
        gameInfoPage.setVisible(false);
        leaderBoardList.refresh();
        GameInfoList.getItems().clear();
        leaderBoardList.getItems().clear();
    }
    @FXML
    protected void backToRegPage() {
        regPage.setVisible(true);
        regPage2.setVisible(false);
        passWordField.clear();
        userNameField.clear();
        regError.setText("");
        regError.setVisible(false);
    }
    @FXML
    protected void regButton(ActionEvent event) {
        regPage.setVisible(false);
        reg2Button.setText(((Button)event.getSource()).getText());
        regPage2.setVisible(true);

    }
    @FXML
    protected void setRegButton2(ActionEvent event) throws SQLException {
        System.out.println(userNameField.getText());
        if (userNameField.getText().equals("") || passWordField.getText().equals("")) {
            regError.setText("    Username and password must be filled");
            regError.setVisible(true);
        }
        else if (((Button)event.getSource()).getText().equals("login")) {
            if (DatabaseManager.validLogin(userNameField.getText(), passWordField.getText())) {
                startGame.setVisible(true);
                regPage2.setVisible(false);
                user.setUsername(userNameField.getText());
                user.setPassword(passWordField.getText());
                passWordField.clear();
                userNameField.clear();
                regError.setText("");
                regError.setVisible(false);
            }
            else {
                regError.setText("                                   login faild");
                regError.setVisible(true);
            }
        }
        else {
            if (!DatabaseManager.validUsername(userNameField.getText())) {
                regError.setText("                 this username already exist");
                regError.setVisible(true);
            }
            else {
                namePage.setVisible(true);
                regPage2.setVisible(false);
                regError.setText("");
                regError.setVisible(false);
                user.setUsername(userNameField.getText());
                user.setPassword(passWordField.getText());
                passWordField.clear();
                userNameField.clear();
            }
        }
    }
    @FXML
    protected void preProcess() {
        mnl = 0;
        cntLet = 0;
        step = 0;
        game = new Game("", "");
        game.setWrongGuesses(0);
        game.setWin(false);
        game.setTime(0);
        if (ft == 1) {
            buttonList.add(aButton);
            buttonList.add(bButton);
            buttonList.add(cButton);
            buttonList.add(dButton);
            buttonList.add(eButton);
            buttonList.add(fButton);
            buttonList.add(gButton);
            buttonList.add(hButton);
            buttonList.add(iButton);
            buttonList.add(jButton);
            buttonList.add(kButton);
            buttonList.add(lButton);
            buttonList.add(mButton);
            buttonList.add(nButton);
            buttonList.add(oButton);
            buttonList.add(pButton);
            buttonList.add(qButton);
            buttonList.add(rButton);
            buttonList.add(sButton);
            buttonList.add(tButton);
            buttonList.add(uButton);
            buttonList.add(vButton);
            buttonList.add(wButton);
            buttonList.add(xButton);
            buttonList.add(yButton);
            buttonList.add(zButton);

            imageViewList.add(hang1);
            imageViewList.add(hang2);
            imageViewList.add(hang3);
            imageViewList.add(head);
            imageViewList.add(body);
            imageViewList.add(leftHand);
            imageViewList.add(rightHand);
            imageViewList.add(leftFoot);
            imageViewList.add(rightFoot);
            imageViewList.add(hang4);

            lettersList.add(letter1);
            lettersList.add(letter2);
            lettersList.add(letter3);
            lettersList.add(letter4);
            lettersList.add(letter5);
            lettersList.add(letter6);
            lettersList.add(letter7);
            lettersList.add(letter8);
            lettersList.add(letter9);
            lettersList.add(letter10);
            lettersList.add(letter11);
            lettersList.add(letter12);
            lettersList.add(letter13);
            lettersList.add(letter14);
            lettersList.add(letter15);
            lettersList.add(letter16);
            lettersList.add(letter17);
            lettersList.add(letter18);
            lettersList.add(letter19);
            lettersList.add(letter20);
        }
        for (int i = 0; i < lettersList.size(); i++) {
            lettersList.get(i).setVisible(false);
        }
        for (int i = 0; i < imageViewList.size(); i++) {
            imageViewList.get(i).setVisible(false);
        }
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).setVisible(true);
        }
    }
    @FXML
    protected void GameInfo(ActionEvent event) throws SQLException {
        gameInfoPage.setVisible(true);
        startGame.setVisible(false);
        List<Game> games = DatabaseManager.getGameInfo(user.getUsername());
        int num = 0;
        for (Game game1 : games) {
            String save = "";
            save += String.valueOf(num + 1) + ") " + game1.getGameId() + "  " + game1.getWord() + "  " + game1.getTime() + "second ";
            if (game1.isWin()) {
                save = save + "  win";
            }
            else {
                save = save + "  lose";
            }
            GameInfoList.getItems().add(num++, save);
        }
    }
    @FXML
    protected void LeaderBoard(ActionEvent event) throws SQLException {
        leaderBoardPage.setVisible(true);
        startGame.setVisible(false);
        List<User> users = DatabaseManager.getUsers();
        for (int i = 0; i < users.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (users.get(j).getNumberOfWin() < users.get(j + 1).getNumberOfWin()) {
                    User user2 = users.get(j);
                    users.set(j + 1, users.get(j));
                    users.set(j, user2);
                }
            }
        }
        int num = 0;
        for (User user1 : users) {
            String save = "";
            save = String.valueOf(num + 1) + ") "  + user1.getUsername() + "   win: " + user1.getNumberOfWin();
            leaderBoardList.getItems().add(num++, save);
            System.out.println(user1.getUsername() + " " + user1.getNumberOfWin());
        }
//        leaderBoardList.scrollTo(leaderBoardList.);
    }
    @FXML
    protected void clickButton(ActionEvent event) {
        Button button = (Button)event.getSource();
        button.setVisible(false);
        int cnt = 0;
        for (int i = 0; i < Mainword.length(); i++) {
            String save2 = "";
            save2 += Mainword.charAt(i);
            save2 = save2.toUpperCase();
            if (save2.equals(button.getText())) {
                cntLet++;
                cnt++;
                String save3 = "";
                save3 += button.getText().charAt(0);
                lettersList.get(i + dis).setText(save2);
            }
        }
        if (cntLet == mnl) {
            fn = LocalDateTime.now();
            duration = Duration.between(st, fn);
            game.setWin(true);
            game.setTime((int)duration.getSeconds());
            game.setWrongGuesses(step);
            gameover();
        }
        if (cnt == 0) {
            step++;
            for (int i = 0; i < step; i++) {
                imageViewList.get(i).setVisible(true);
            }
            if (step == imageViewList.size()) {
                fn = LocalDateTime.now();
                duration = Duration.between(st, fn);
                game.setWin(false);
                game.setTime((int)duration.getSeconds());
                game.setWrongGuesses(step);
                gameover();
            }
       }
    }
    @FXML
    protected void GoToMenu() {
        GameOver.setVisible(false);
        startGame.setVisible(true);
        startButton.setVisible(true);
    }
    @FXML
    protected void gameover() {
        DatabaseManager.newGame(game);
        gameTime.setText("time: " + String.valueOf(duration.getSeconds()) + "second");
        wrongGuess.setText("wrong guess: " + step);
        GameOver.setVisible(true);
    }
    @FXML
    protected void gameStart(ActionEvent event) {
        st = LocalDateTime.now();
        System.out.println(st);
        ft++;
        preProcess();
        Button button = (Button)event.getSource();
        Mainword = HangMan.getRandWord();
        for (int i = 0; i < Mainword.length(); i++) {
            if (Mainword.charAt(i) != ' ')
                mnl++;
        }
        game.setWord(Mainword);
        game.setUsername(user.getUsername());
        dis = 20 - Mainword.length();
        dis /= 2;
        for (int i = 0; i < Mainword.length(); i++) {
            String save2 = "";
            save2 += Mainword.charAt(i);
            lettersList.get(i + dis).setText("");
            if (!save2.equals(" "))
                lettersList.get(i + dis).setVisible(true);
        }
        startGame.setVisible(false);
    }
}