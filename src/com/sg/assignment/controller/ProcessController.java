package com.sg.assignment.controller;

import java.util.List;
import java.util.Scanner;

import com.sg.assignment.model.User;
import com.sg.assignment.service.UserService;

public class ProcessController {

	public static void handleOperations(Scanner input,int operation, UserService userService) {
		
	switch (operation) {
	case 1:
		handleRegistration(input, userService);
		break;
		
	case 2:
		handleUpdate(input, userService);
		break;
		
	case 3:
		handleDisplay(userService);
		break;
		
	case 4:
		handleDelete(input, userService);
		break;
		
		
	case 0:
		System.exit(0);
		break;

	default:
		break;
	}
		
		
	}

	private static void handleDelete(Scanner input, UserService userService) {
		renderOperationTitle("Delete");
		System.out.println("user id: ");
		int userId = input.nextInt();
		
		int userDeleted = userService.delete(userId);
		
		printSuccessOrFailure(userDeleted, "Delete");
		
		System.out.println("-------------------------------------------------------------------");
	}

	private static void handleDisplay(UserService userService) {
		List<User> users=  userService.displayUserData();
		users.stream().forEach((user) -> System.out.println(user));
		
	}

	private static void handleUpdate(Scanner input, UserService userService) {
		renderOperationTitle("Update");
		User user = acceptInputAndBuildUser(input);
		System.out.println("User id: ");
		int userId = input.nextInt();
		
		int updatedUser = userService.update(new User(user.getFirstName(), user.getLastName(),user.getEmail(),userId));
		printSuccessOrFailure(updatedUser, "Upadte");
		
		System.out.println("-------------------------------------------------------------------");
	}

	/**
	 * @param input
	 * @param userService
	 */
	private static void handleRegistration(Scanner input, UserService userService) {
		renderOperationTitle("Registration");
		
		User user = acceptInputAndBuildUser(input);
		int register = userService.register(user);
		printSuccessOrFailure(register, "Registration");
		
		System.out.println("-------------------------------------------------------------------");
	}

	/**
	 * @param register
	 */
	private static void printSuccessOrFailure(int register, String operation) {
		if(register>0) {
			System.out.println("User "+ operation+ " done successfully");
		}else {
			System.out.println(operation+" failure");
		}
	}

	/**
	 * 
	 */
	private static void renderOperationTitle(String titleText) {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("User "+titleText);
		System.out.println("-------------------------------------------------------------------");
	}

	/**
	 * @param input
	 * @return
	 */
	private static User acceptInputAndBuildUser(Scanner input) {
		System.out.println("First name : ");
		String firstName= input.next();
		
		System.out.println("Last name : ");
		String lastName= input.next();
		
		System.out.println("Email : ");
		String email= input.next();
		
		return new User(firstName, lastName, email);

	}
}
