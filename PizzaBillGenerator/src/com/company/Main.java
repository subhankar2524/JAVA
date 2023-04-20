package com.company;
import java.util.Scanner;

class pizza{
    boolean isVeg;
    int basePrice;
    int totalBill;
    int exTop;
    int exCheese;
    int bag;
    public void getBill(){
        System.out.println("1. Dine In");
        System.out.println("2. Take away");
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        System.out.println("Base price of the pizza: "+ basePrice);
        if(exCheese!=0){
            System.out.println("Extra Cheese Added: Rs. "+ exCheese);
        }
        if(exTop!=0){
            System.out.println("Extra Toppings Added: Rs. "+ exTop);
        }
        totalBill = bag+exTop+exCheese+basePrice;
        if(val == 1){
            System.out.println("Total payable amount: Rs. "+ totalBill);
        }
        else if(val == 2){
            bag = 20;
            System.out.println("Bag added: 20");
            System.out.println("Total payable amount: Rs. "+ totalBill);
        }
    }
    public void menu(){
        System.out.println("1. Veg Pizza");
        System.out.println("2. Non veg Pizza");
        System.out.println("3. Cancel order");
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        if(val==1){
            System.out.println("Veg pizza selected");
            basePrice = 300;
            isVeg = true;
            menu(isVeg);
        }
        else if(val ==2){
            System.out.println("Non-veg pizza selected");
            basePrice = 400;
            isVeg = false;
            menu(isVeg);
        }
        else if(val ==3){
            System.out.println("Order Cancelled !!");
            return;
        }
        else{
            System.out.println("Enter correct options");
        }

    }
    public void menu(boolean isVeg){
            System.out.println("1. Add extra cheese     4. Cancel Order");
            System.out.println("2. Add extra toppings   5. Remove Cheese");
            System.out.println("3. Place Order          6. Remove Toppings");
//            System.out.println("4. Cancel Order");
//            System.out.println("5. Remove Cheese");
//            System.out.println("6. Remove Toppings");
            Scanner sc = new Scanner(System.in);
            int val = 0;
            while(val != 3 && val != 4){
                val = sc.nextInt();
                if(val == 1){
                    addCheese();
                }
                else if(val == 2){
                    addTopping(isVeg);
                }
                else if(val == 3){
                    getBill();
                }
                else if(val == 4){
                    System.out.println("Order Canceled !!");
                    return;
                }
                else if (val == 5){
                    System.out.println("Extra Cheese removed");
                    exCheese =0;
                }
                else if (val == 6){
                    System.out.println("Extra Toppings removed");
                    exTop =0;
                }
                else{
                    System.out.println("enter correct value");
                }
            }
    }
    public void addTopping(boolean isVeg){
        if(isVeg==true){
            exTop = 70;
        }
        else{
            exTop = 120;
        }
        System.out.println("Extra toppings added");
    }
    public void addCheese(){
        exCheese = 80;
        System.out.println("Extra cheese added");
    }

}
public class Main {
    public static void main(String[] args) {
	// write your code here
        pizza p1  = new pizza();
        p1.menu();
    }
}