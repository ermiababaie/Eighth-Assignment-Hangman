package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HangMan   {
    public static List<String> words = new ArrayList<>();
    public static String hash(String pas) {
        String pass = pas + "This Is Salt For My hash";
        long mod = 1000000007, mod2 = 1000000009, mabna = 457, mabna2 = 701;
        long ans = 0, ans2 = 0, pow = 1, pow2 = 1;
        for (int i = 0; i < pass.length(); i++) {
            int save = pass.charAt(i) - ' ';
            ans = (ans + (pow * save)) % mod;
            pow = (pow * mabna) % mod;
            ans2 = (ans2 + (pow2 * save)) % mod2;
            pow2 = (pow2 * mabna2) % mod2;

        }
        return String.valueOf(ans) + "#" + String.valueOf(ans2);
    }
    public static void preFruit() {
        words.add("apple");
        words.add("banana");
        words.add("blackberry");
        words.add("cherry");
        words.add("grapefruit");
        words.add("kiwi");
        words.add("lemon");
        words.add("lime");
        words.add("mango");
        words.add("orange");
        words.add("pear");
        words.add("pineapple");
        words.add("pomegranate");
        words.add("strawberry");
        words.add("watermelon");
    }
    public static void preJobs() {
        words.add("actor");
        words.add("architect");
        words.add("baker");
        words.add("cleaner");
        words.add("dentist");
        words.add("designer");
        words.add("doctor");
        words.add("lawyer");
        words.add("nurse");
        words.add("painter");
        words.add("policeman");
        words.add("postman");
        words.add("real estate agent");
        words.add("taxi driver");
        words.add("teacher");
    }

    public static void preAnimals() {
        words.add("dog");
        words.add("cat");
        words.add("horse");
        words.add("lion");
        words.add("tiger");
        words.add("cow");
        words.add("snake");
        words.add("wolf");
        words.add("bears");
        words.add("fish");
        words.add("sheep");
        words.add("deer");
        words.add("camel");
        words.add("spider");
        words.add("goat");
    }

    public static String getRandWord() {
        //edit (API)
        Random random = new Random();
        int num = random.nextInt(words.size());
        return words.get(num);
    }
}