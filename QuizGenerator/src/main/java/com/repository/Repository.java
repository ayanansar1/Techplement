package com.repository;

import com.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Repository {
	public Repository() {
	}
	public static Map<String, Quiz> quizzes = new HashMap<>();
	
	public static void createQuiz(Scanner scanner) {
		try {
        System.out.println("Enter the name of the quiz:");
//        String quizName = takeStringFromUser(scanner);
        String quizName = scanner.nextLine();
        Quiz quiz = new Quiz(quizName);
        System.out.println("Enter the number of questions:");
        int numQuestions = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numQuestions; i++) {
            System.out.println("Enter the question:");
            String question = scanner.nextLine();
            
            System.out.println("Enter the number of choices:");
            
//            String ch;
//            while(true) {
//            	ch = scanner.nextLine();
//            	boolean isNum = isNumber(ch);
//            	if(isNum) break;
//            	else System.out.println("Please enter any digit!");
//            }
           
            int numChoices = takeNumberFromUser(scanner); //Integer.parseInt(ch);
            
            List<String> choices = new ArrayList<>();
            for (int j = 0; j < numChoices; j++) {
                System.out.println("Enter choice " + (j+1) + ":");
                String choice = scanner.nextLine();
                choices.add(choice);
            }
            System.out.println("Enter the index of the correct choice:");
            int correctChoice = Integer.parseInt(scanner.nextLine()) - 1;
            quiz.addQuestion(new Question(question, choices, correctChoice));
        }
        quizzes.put(quizName, quiz);
        System.out.println("Quiz created.");
    }		
		catch(Exception e) {
    	System.out.println("invalid input. please Enter valid input");
    }
	}
		

	
	
	public static void takeQuiz(Scanner scanner) {
		try {
        System.out.println("Enter the name of the quiz:");
        String quizName = scanner.nextLine();
        Quiz quiz = quizzes.get(quizName);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }
        int score = 0;
        for (int i = 0; i < quiz.getNumQuestions(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println("Question " + (i+1) + ": " + question.getQuestion());
            List<String> choices = question.getChoices();
            for (int j = 0; j < choices.size(); j++) {
                System.out.println((j+1) + ": " + choices.get(j));
            }
            System.out.println("Enter your answer:");
            int userAnswer = Integer.parseInt(scanner.nextLine()) - 1;
            if (userAnswer == question.getCorrectChoice()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + (question.getCorrectChoice()+1) + ".");
            }
        }
        System.out.println("Your score is " + score + " out of " + quiz.getNumQuestions() + ".");
    }catch(Exception e) {
    	System.out.println("invalid input. please enter valid input");
    }
}
    
    
	public static void viewQuiz(Scanner scanner) {
		try {
        System.out.println("Enter the name of the quiz:");
        String quizName = scanner.nextLine();
        Quiz quiz = quizzes.get(quizName);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;}
                System.out.println("Quiz: " + quiz.getName());
    for (int i = 0; i < quiz.getNumQuestions(); i++) {
        Question question = quiz.getQuestion(i);
        System.out.println("Question " + (i+1) + ": " + question.getQuestion());
        List<String> choices = question.getChoices();
        for (int j = 0; j < choices.size(); j++) {
            System.out.println((j+1) + ": " + choices.get(j));
        }
        System.out.println("Answer: " + (question.getCorrectChoice()+1));
    }
}catch(Exception e) {
	System.out.println("invalid input. please enter valid input");
	}
}
    

	public static void listQuizzes() {
	try {
    System.out.println("Quizzes:");
    for (String quizName : quizzes.keySet()) {
        System.out.println("- " + quizName);
    }
}catch(Exception e) {
	System.out.println("invalid input. please enter valid input");
	}
}
	
	private static boolean isNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Check if the character is a digit or a negative sign (only allowed at the start)
            if (!Character.isDigit(c) && (i != 0 || c != '-')) {
                return false;
            }
        }
        
        return true;
    }
	
	private static boolean isText(String str) {
		//write  logic for text check
		return false;
	}
	
	private static int takeNumberFromUser(Scanner scanner) {
		String ch;
		while(true) {
        	ch = scanner.nextLine();
        	boolean isNum = isNumber(ch);
        	if(isNum) break;
        	else System.out.println("Please enter any digit!");
        }
		return Integer.parseInt(ch);
	}
	
	private static String takeStringFromUser(Scanner scanner) {
		//looping till you get right text
		return null;
	}
}


