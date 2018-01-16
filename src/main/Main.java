package main;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import connectivity.ConcDao;
import controller.Controller;
import model.Expediture;
import model.Supply;
import view.Window;

public class Main {

	private static Window window;
	private static Controller controller;
	private static ConcDao dao;
	private static List<Supply> supplies;
	private static List<Expediture> expeditures;
	private static int totalSugar;
	private static int soldInTotal;

	public static void main(String[] args) throws SQLException {
		dao = new ConcDao();
		loadAndSortData();

		EventQueue.invokeLater(() -> {
			window = new Window();
			controller = new Controller(window, dao);
		});

	}

	public static void loadAndSortData() throws SQLException {
		supplies = dao.getAllSupply();
		supplies.sort((a, b) -> (int) (a.getDate() - b.getDate()));

		expeditures = dao.getAllExpediture();
		expeditures.sort((a, b) -> (int) (a.getDate() - b.getDate()));

	}

	public static void totalWorth() {
		int worth = 0;
		int foo = 0;
		soldInTotal = 0;
		totalSugar = 0;
		
		for (Expediture exp : expeditures) {
			foo += exp.getAmount();
		}

		soldInTotal = foo;

		for (Supply sup : supplies) {
			int supplySize = sup.getAmount();
			totalSugar += supplySize;
			if (supplySize <= foo) {
				foo -= supplySize;
				supplySize = 0;
			} else {
				supplySize -= foo;
				foo = 0;
			}
			worth += supplySize * sup.getUnitPrice();

		}
		totalSugar -= soldInTotal;
		System.out.println("we have: " + totalSugar + " sugar left.");
		System.out.println("Sugar is worth: " + worth);

	}

	public static int getTotalSugar() {
		return totalSugar;
	}
	
	

}
