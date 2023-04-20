package com.company;

import java.util.Scanner;

class ATM{
    float Balance;
    int pin;
    int wrongPin = 0;
    ATM(){
        this.Balance=0;
        this.pin = 1111;
    }

    public void checkPin(){
        System.out.println("Enter Your pin: ");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();
        if(enteredPin==pin){
            menu();
        }
        if(wrongPin==2){
            System.out.println("transaction cancelled ");
            return;
        }
        else{
            System.out.println("Enter a valid pin");
            wrongPin += 1;
            checkPin();
        }
    }
    public void menu(){
        System.out.println("Enter your choice:");
        System.out.println("1. Check A/C Balance    2. Withdraw Money");
        System.out.println("3. Deposit Money        4. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
//        sc.close();
        if(opt==1){
            checkBalance();
        }
        else if(opt ==2){
            withdrawMoney();
        }
        else if(opt ==3){
            depositMoney();
        }
        else if(opt==4){

            return;
        }
        else{
            System.out.println("enter a valid choice");
        }
    }
    public void checkBalance(){
        System.out.println("Rs. "+Balance);
        menu();
    }
    public void withdrawMoney(){
        System.out.println("Enter Amount:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
//        sc.close();
        if(amount>Balance){
            System.out.println("Insufficient Balance");
        }
        else{
            Balance = Balance - amount;
            System.out.println("Money withdrawn successfully");
        }
        menu();
    }
    public void depositMoney(){
        System.out.println("Enter Cash:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
//        sc.close();
        Balance+= amount;
        System.out.println("Money deposited Successfully");
        menu();
    }

}
public class ATMMachine {
    public static void main(String[] args) {
        ATM customer1 = new ATM();
        customer1.checkPin();
    }
}
