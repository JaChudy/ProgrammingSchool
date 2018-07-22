package pl.coderslab.controller;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import pl.coderslab.entity.UserGroup;
import pl.coderslab.service.UserGropuService;

import java.util.Scanner;

public class UserGroupController {
    static void startManagingUsers(){

        int action = choseAction();

        switch (action){
            case 0: MainController.startMainMenu(); break;
            case 1: addGroup();    break;
            case 2: editGroup();   break;
            case 3: deleteGroup(); break;
            case 4: printAll();    break;
        }

    }


    static public void addGroup(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Starting to add user group");
        System.out.println("Group name: ");
        String userGroup = scan.nextLine();
        try {
            UserGropuService.add(userGroup);
        }catch (Exception e){
            System.out.println(e.getMessage());
            addGroup();
        }
       // return userGroup1.getName();

        //Call to UserGroupService to method to add user group
//        UserGroupService.add(userGroup)
    }

    static private void editGroup(){
        //printAll();
        Scanner scan  = new Scanner(System.in);
        System.out.println("Which group name do you want to edit?\n " +
                "Enter the group number");
        while (!scan.hasNextInt()){
            System.out.println("To nie jest liczba całkowita");
            editGroup();
        }
            int userGroupId = scan.nextInt();
            scan.nextLine();
            System.out.println("Podaj nową zawę grupy");
            String newGroupName = scan.nextLine();
            UserGropuService.edit(userGroupId, newGroupName);


    }

    static private void deleteGroup(){

    }

    private static void printAll(){
        System.out.println("Print all user groups");
        try {
            UserGropuService.printAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        startManagingUsers();
    }

    private static int choseAction(){

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("What you want to do with User Groups:");
            System.out.println("1 - Add");
            System.out.println("2 - Edit");
            System.out.println("3 - Delete");
            System.out.println("4 - List all");
            System.out.println("0 - Main menu");

            try{
                int option = scan.nextInt();
                if(option < 0 || option > 4){
                    throw new Exception("Wrong value");
                }
                return option;
            }catch (Exception e){
                System.out.println("Wrong value");
                scan.next();
            }

        }

    }

}
