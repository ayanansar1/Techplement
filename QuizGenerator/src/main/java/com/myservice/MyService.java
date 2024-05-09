package com.myservice;
import java.util.Scanner;

import com.repository.*;

 public class MyService {
	Repository repo=new Repository();
	public void  creatQuiz(Scanner scanner) {
		repo.createQuiz(scanner);
	}

	public void takeQuiz(Scanner scanner) {
		repo.takeQuiz(scanner);
		
	}
	
	public void viewQuiz(Scanner scanner) {
		repo.viewQuiz(scanner);
	} 
	
	public void listQuiz() {
		repo.listQuizzes();
	}
	
	

}
