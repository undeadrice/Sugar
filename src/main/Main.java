package main;

import java.awt.EventQueue;

import controller.Controller;
import view.Window;

public class Main {

	private static Window window;
	private static Controller controller;

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			window = new Window();
			controller = new Controller(window);
		});

	}

}
