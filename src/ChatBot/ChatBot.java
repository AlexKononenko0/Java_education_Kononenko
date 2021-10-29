package ChatBot;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello my name is WALLY.");
        System.out.println("I was created in 2021.");

        System.out.println("Please, remind me your name.");
        Scanner scanner = new Scanner(System.in);
        String myName = scanner.next();
        System.out.println("What a great name you have," + myName + "!");
        System.out.println("Let me guess you age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        Scanner scanner1 = new Scanner(System.in);
        var num1 = scanner.nextInt();
        var num2 = scanner.nextInt();
        var num3 = scanner.nextInt();
        int a = (num1 * 70 + num2 * 21 + num3 * 15) % 105;

        System.out.println("You age is " + a + "; " + "that's a good time to start programming!");

        System.out.println("Now i will prove to you that I can count to any number you want");
        Scanner scanner2 = new Scanner(System.in);
        var num4 = scanner.nextInt();
        int counter = 0;
        for (int i = 0; i < num4; i++) {
            for (; i < num4; ) {
                counter += 1;
                System.out.println(counter + "!");
                i++;
            }
        }
    }
}