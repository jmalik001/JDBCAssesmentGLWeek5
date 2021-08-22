package com.sg.assignment;

import java.util.Scanner;

import com.sg.assignment.controller.ProcessController;
import com.sg.assignment.service.UserService;
import com.sg.assignment.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		UserService userService = new UserServiceImpl();
		while (true) {
			Menu.displayMenues();
			int option = input.nextInt();
			ProcessController.handleOperations(input, option, userService);
		}

	}

}
