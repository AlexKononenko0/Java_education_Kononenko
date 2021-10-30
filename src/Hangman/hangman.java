package Hangman;

import java.util.Locale;
import java.util.Scanner;


public class hangman {
    public static void main(String[] args) {
        String str = "HANGMAN";
        String str2 ="The game will be available soon";
        String Up = str.toUpperCase(Locale.ROOT);
        System.out.println(str + "\n"+str2);
        Scanner scanner = new Scanner(System.in);
        String response;
        label:
        while (true){
            response = scanner.nextLine();
            switch (response) {
                case "python":
                    System.out.println("You lost!");
                    break label;
                case "java":
                    System.out.println("You survived!");
                    break label;
            }
        }
    }
}