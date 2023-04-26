package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Commands :");
        System.out.println("press [e + enter] to end game");
        System.out.println("Player1 fire gun 1 -> [a + enter]");
        System.out.println("Player1 fire gun2 -> [s + enter]");
        System.out.println("Player1 heals -> [d + enter]");

        System.out.println("Player2 fire gun 1 -> [j + enter]");
        System.out.println("Player2 fire gun2 -> [k + enter]");
        System.out.println("Player2 heals -> [l + enter]");

        System.out.println("Start Playing...");

        Player1 player1 = new Player1("Totan", "AK 47", -20);
        Player2 player2 = new Player2("Tubai", "Brahmastra", 90, true);

        Scanner sc = new Scanner(System.in);
        char c = 'q';
        while(c!='e'){
            c = sc.next().charAt(0);
            if(c=='a'){
                player1.damageByGun1();
            }
            else if(c == 's'){
                player1.damageByGun2();
            }
            else if(c == 'd'){
                player1.heal();
            }
            else if(c=='j'){
                player2.damageByGun1();
            }
            else if(c == 'k'){
                player2.damageByGun2();
            }
            else if(c == 'l'){
                player2.heal();
            }
        }
    }
}
