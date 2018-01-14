package controller;

import view.Window;

public class Controller {

	private Window window;

	public Controller(Window window) {
		this.window = window;

		addListeners();
		
	}

	private void addListeners() {

		window.getMainPage().getBuy().addActionListener(ae -> {
			window.getMainPage().getBuyCount().setText("");
			window.getMainPage().getBuyPrice().setText("");
		});
		
		window.getMainPage().getSell().addActionListener(ae -> {
			window.getMainPage().getSellCount().setText("");
		});

		
		
		
	}

}
