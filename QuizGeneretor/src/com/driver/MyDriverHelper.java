package com.driver;

import java.util.Scanner;


import com.myservice.*;

public class MyDriverHelper {
        Scanner scanner = new Scanner(System.in);
        MyService myservice = new MyService();
        boolean running = true;
        
        private void display() {
            System.out.println("\nOptions:");
            System.out.println("1. Create Quiz");
            System.out.println("2. Take Quiz");
            System.out.println("3. View Quiz");
            System.out.println("4. List Quizzes");
            System.out.println("5. Exit");
            System.out.println("Choose an option:");
       
      }

//        public void run() {
//        	while(running) {
//	        	display();
//	        	handleChoice();
//        	}
//        	scanner.close();
//        }
        
        public void run() {
            int choice;
            do {
                display();
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    handleChoice(choice);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    choice = -1; // Set choice to an invalid value to continue the loop
                }
            } while (choice != 5);
            scanner.close();
        }
        
        private void handleChoice(int choice) {
            
            switch (choice) {
                case 1:
                    myservice.creatQuiz(scanner);
                    break;
                case 2:
                    myservice.takeQuiz(scanner);
                    break;
                case 3:
                    myservice.viewQuiz(scanner);
                    break;
                case 4:
                    myservice.listQuiz();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    
//        private void handleChoice() {
//		    while (running) {
//		        String command = scanner.nextLine();
//		        if (command.equals("1")) {
//		            myservice.creatQuiz(scanner);
//		        } else if (command.equals("2")) {
//		            myservice.takeQuiz(scanner);
//		        } else if (command.equals("3")) {
//		            myservice.viewQuiz(scanner);
//		        } else if (command.equals("4")) {
//		            myservice.listQuiz();
//		        } else if (command.equals("5")) {
//		            running = false;
//		        } else {
//		            System.out.println("Invalid command.");
//		        }
//	    }
//		    scanner.close();
//
//    }

}

