package CoffeeMachine;

import java.util.*;
import java.util.Scanner;
import java.lang.Runtime;

public class CoffeeMachine{
    static int[] Money = {550};
    static int[] Water = {400};
    static int[] Milk = {540};
    static int[] CoffeeBeanSin = {120};
    static int[] Disposablecups = {9};

    public static void main(String[] args) {
        coffeemachine();

    }

    static void coffeemachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action(buy, fill, take , remaining, exit):");
        String action = scanner.nextLine();
        for (int i = 1; i >= i - 1; i++) {
            if (Objects.equals(action, "exit")) {Runtime.getRuntime().exit(0);}
            if (Objects.equals(action, "buy")) {buy();}
            if (Objects.equals(action, "fill")) {fill();}
            if (Objects.equals(action, "remaining")) {remaining();}
            if (Objects.equals(action, "take")) {take();}
        }
    }




    static void buy() {
        enum Coffee{Null,Espresso,Latte,Cappuccino,Back;
        }
        Scanner scannerBuy = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - Espresso, 2 - Latte, 3 - Cappuccino,4 - Back to main menu.");
        int coffee = scannerBuy.nextInt();
        if (Objects.equals(coffee,Coffee.Espresso.ordinal())) {
            if (Water[0] < 250 || CoffeeBeanSin[0] < 16 || Disposablecups[0] < 1) {
                if (Water[0] < 250) {System.out.println("Sorry, not enough water!");coffeemachine();}
                if (CoffeeBeanSin[0] < 16) {System.out.println("Sorry, not enough coffee beans!");coffeemachine();}
                if (Disposablecups[0] < 1) {System.out.println("Sorry, not enough disposable cups!");coffeemachine();}
            } else {
                Money[0] += 4;
                Water[0] -= 250;
                CoffeeBeanSin[0] -= 16;
                Disposablecups[0] -= 1;
                System.out.println("I have enough resources, making you a coffee!");
                coffeemachine();
            }
        }
        if (Objects.equals(coffee,Coffee.Latte.ordinal())) {
            if (Water[0] < 350 || Milk[0] < 75 || CoffeeBeanSin[0] < 20 || Disposablecups[0] < 1) {
                if (Water[0] < 350) {System.out.println("Sorry, not enough water!");coffeemachine();}
                if (CoffeeBeanSin[0] < 20) {System.out.println("Sorry, not enough coffee beans!");coffeemachine();}
                if (Milk[0] < 75) {System.out.println("Sorry, not enough milks");coffeemachine();}
                if (Disposablecups[0] < 1) {System.out.println("Sorry, not enough disposable cups!");coffeemachine();}
            } else {
                Money[0] += 7;
                Water[0] -= 350;
                CoffeeBeanSin[0] -= 20;
                Milk[0] -= 75;
                Disposablecups[0] -= 1;
                System.out.println("I have enough resources, making you a coffee!");
                coffeemachine();
            }
        }
        if (Objects.equals(coffee,Coffee.Cappuccino.ordinal())) {
            if (Water[0] < 200 || Milk[0] < 100 || CoffeeBeanSin[0] < 12 || Disposablecups[0] < 1) {
                if (Water[0] < 200) {System.out.println("Sorry, not enough water!");coffeemachine();}
                if (CoffeeBeanSin[0] < 12) {System.out.println("Sorry, not enough coffee beans!");coffeemachine();}
                if (Milk[0] < 100) {System.out.println("Sorry, not enough milks");coffeemachine();}
                if (Disposablecups[0] < 1) {System.out.println("Sorry, not enough disposable cups!");coffeemachine();}
            } else {
                Money[0] += 6;
                Water[0] -= 200;
                CoffeeBeanSin[0] -= 12;
                Milk[0] -= 100;
                Disposablecups[0] -= 1;
                System.out.println("I have enough resources, making you a coffee!");
                coffeemachine();
            }
        }
        if (Objects.equals(coffee,Coffee.Back.ordinal())) {
            coffeemachine();
        }
    }

    static void fill() {
        Scanner scannerFill = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water_fill = scannerFill.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk_fill = scannerFill.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee_beans_fill = scannerFill.nextInt();
        System.out.println("Write how many disposable cups the coffee machine has:");
        int disposable_cups_fill = scannerFill.nextInt();
        Water[0] += water_fill;
        Milk[0] += milk_fill;
        CoffeeBeanSin[0] += coffee_beans_fill;
        Disposablecups[0] += disposable_cups_fill;
        coffeemachine();
    }

    static void remaining() {
        System.out.println("The coffee machine has:\n"+
                Water[0] +" of water\n" +
                Milk[0] +" of milk\n" +
                CoffeeBeanSin[0] +" of coffee beans\n"+
                Disposablecups[0] +" of disposable cups\n"+
                Money[0] +" of money");
        coffeemachine();
    }

    static void take() {
        System.out.println("I gave you " + Money[0]);
        Money[0] = 0;
        coffeemachine();
    }
}