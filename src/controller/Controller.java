package controller;

import java.sql.SQLException;

import connectivity.ConcDao;
import main.Main;
import model.Expediture;
import model.Supply;
import view.Window;

public class Controller {

	private Window window;
	private ConcDao dao;

	public Controller(Window window, ConcDao dao) {
		this.window = window;
		this.dao = dao;
		addListeners();
	}

	private void addListeners() {

		window.getMainPage().getBuy().addActionListener(ae -> {
			try {

				dao.insertSupply(new Supply(null, 1, Integer.parseInt(window.getMainPage().getBuyCount().getText()),
						Double.parseDouble(window.getMainPage().getBuyPrice().getText()), System.currentTimeMillis()));

				window.getMainPage().getBuyCount().setText("");
				window.getMainPage().getBuyPrice().setText("");
				Main.loadAndSortData();
				Main.totalWorth();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		});

		window.getMainPage().getSell().addActionListener(ae -> {

			try {
				if (Double.parseDouble(window.getMainPage().getSellCount().getText()) > Main.getTotalSugar()) {
					System.out.println("nie ma tyle cukru");
				} else {
					dao.insertExpediture(
							new Expediture(null, 1, Integer.parseInt(window.getMainPage().getSellCount().getText()),
									System.currentTimeMillis()));
					window.getMainPage().getSellCount().setText("");
					Main.loadAndSortData();
					Main.totalWorth();
				}
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		});

		window.getMainPage().getStatus().addActionListener(ae -> {
			try {
				Main.loadAndSortData();
				Main.totalWorth();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		});

	}

}
