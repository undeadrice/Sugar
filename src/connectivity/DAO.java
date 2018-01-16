package connectivity;

import java.sql.SQLException;
import java.util.List;

import model.Expediture;
import model.Product;
import model.Supply;

public interface DAO {

	String db = "jdbc:sqlite:\\C:\\Users\\PC\\Desktop\\Brucki Kamil\\sugarShop.db";

	List<Product> getAllProducts() throws SQLException;

	void insertProduct(Product p) throws SQLException;

	void removeProduct(Product p) throws SQLException;

	void updateProduct(Product p) throws SQLException;

	List<Supply> getAllSupply() throws SQLException;

	void insertSupply(Supply supply) throws SQLException;

	void removeSupply(Supply supply) throws SQLException;

	void updateSupply(Supply supply) throws SQLException;

	List<Expediture> getAllExpediture() throws SQLException;

	void insertExpediture(Expediture expediture) throws SQLException;

	void removeExpediture(Expediture expediture) throws SQLException;

	void updateExpediture(Expediture expediture) throws SQLException;

}
