package pl.coderslab.controller;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {

        startMainMenu();


    }

    public static void startMainMenu() {

        System.out.println("=================================");
        System.out.println("=====WELCOME TO OUT SCHOOL=======");
        System.out.println("=================================");
        System.out.println("=================================");
        System.out.println("====TRY NOT TO FAIL EXAMS :D ====");
        System.out.println("=================================");

        int action = choseAction();
        switch (action) {
            case 1:
                System.out.println("Option 1");
                break;
            case 2:
                UserGroupController.startManagingUsers();
                break;
            case 3:
                System.out.println("Option 3");
                break;
            case 4:
                System.out.println("Option 4");
                break;
        }
    }

    private static int choseAction() {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("What you want to do:");
            System.out.println("1 - Manage users");
            System.out.println("2 - Manage user group");
            System.out.println("3 - Manage questions");
            System.out.println("4 - Take exam");

            try {
                int option = scan.nextInt();
                if (option < 1 || option > 4) {
                    throw new Exception("Wrong value");
                }
                return option;
            } catch (Exception e) {
                System.out.println("Wrong value");
                scan.next();
            }

        }
    }
}
