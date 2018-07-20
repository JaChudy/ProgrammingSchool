package pl.coderslab.controller;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {

        int action = choseAction();
        switch (action){
            case 1: System.out.println("Option 1");break;
            case 2: System.out.println("Option 2");break;
            case 3: System.out.println("Option 3");break;
            case 4: System.out.println("Option 4");break;
        }

    }

    private static int choseAction(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("What you want to do?");
            System.out.println("1 - Manage users");
            System.out.println("2 - Manage user group");
            System.out.println("3 - Manage questions");
            System.out.println("4 - Take exam");

            try{
                int option = scan.nextInt();
                if(option<1 || option > 4){
                    throw new Exception("Wrong value");
                }
            } catch (Exception e){
                System.out.println("Nie poprawna wartosc");
                scan.next();
            }
        }
    }
}
