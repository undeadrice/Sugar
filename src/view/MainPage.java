package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPage extends JPanel {

	JButton buy, sell;
	JTextField buyCount, sellCount;
	JTextField buyPrice;

	public MainPage() {

		super();

		setPreferredSize(new Dimension(200, 200));

		buy = new JButton("buy");
		sell = new JButton("sell");

		buyCount = new JTextField("buy count", 15);
		sellCount = new JTextField("sell count", 15);
		buyPrice = new JTextField("price", 15);
		
		add(buyCount);
		add(buyPrice);
		add(buy);

		add(sellCount);
		add(sell);
	}

	public JButton getBuy() {
		return buy;
	}

	public JButton getSell() {
		return sell;
	}

	public JTextField getBuyCount() {
		return buyCount;
	}

	public JTextField getSellCount() {
		return sellCount;
	}

	public JTextField getBuyPrice() {
		return buyPrice;
	}
	
	

}
