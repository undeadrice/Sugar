package view;

import javax.swing.JFrame;

public class Window extends JFrame {

	private MainPage mainPage;

	public Window() {

		setSize(200, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		mainPage = new MainPage();
		add(mainPage);

	}

	public MainPage getMainPage() {
		return mainPage;
	}

}
