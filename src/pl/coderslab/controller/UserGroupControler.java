package pl.coderslab.controller;

import java.util.Scanner;

public class UserGroupControler {



    static void addUser(){
        System.out.println("Starting to add user group");
    }
    static void  startManagingUser(){

    }

    private static int choseAction(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("What you want to do?");
            System.out.println("1 - ");
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
