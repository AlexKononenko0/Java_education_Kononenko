package Hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        String str = "HANGMAN";
        String str2 ="The game will be available soon";
        String Up = str.toUpperCase(Locale.ROOT);
        System.out.println(str + "\n"+str2);

        ArrayList<String> list = new ArrayList<>();
        list.add("python");
        list.add("java");
        list.add("javascript");
        list.add("kotlin");
        list.add("php");

        Random random = new Random();
        int randomitem = random.nextInt(list.size());
        String randomElement = list.get(randomitem);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Guess the word:");
        String response;
        label:
        while (true){
            response = scanner.nextLine();
            switch (response) {
                case ("python"):
                case ("java"):
                case ("javascript"):
                case ("kotlin"):
                case ("php"):
                    if(response.length() < randomElement.length())
                        System.out.println("You lost!");
                    if(response.length() > randomElement.length())
                        System.out.println("You lost!");
                    if (response.length() == randomElement.length())
                            System.out.println("You survived!");
                    break label;
            }

        }
    }
}