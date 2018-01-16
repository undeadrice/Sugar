package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Expediture;
import model.Product;
import model.Supply;

public class ConcDao implements DAO {

	@Override
	public List<Product> getAllProducts() throws SQLException {

		List<Product> products = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("select * from product")) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Product product = new Product(rs.getInt("id"), rs.getString("name"));
				products.add(product);

			}

		}

		return products;
	}

	@Override
	public void insertProduct(Product p) throws SQLException {

		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("insert into product values(null,?)");

		) {
			ps.setString(1, p.getName());
			ps.executeUpdate();

		}

	}

	@Override
	public void removeProduct(Product p) throws SQLException {

		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("delete from product where id = ?");

		) {
			ps.setInt(1, p.getId());
			ps.executeUpdate();

		}
	}

	@Override
	public void updateProduct(Product p) throws SQLException {

		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("update product set name = ? where id = ?");

		) {
			ps.setString(1, p.getName());
			ps.setInt(2, p.getId());
			ps.executeUpdate();
		}

	}

	@Override
	public List<Supply> getAllSupply() throws SQLException {
		List<Supply> supplies = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("select * from supply");) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Supply supply = new Supply(rs.getInt("id"), rs.getInt("product_id"), rs.getInt("amount"),
						rs.getDouble("unit_price"), rs.getLong("date"));
				supplies.add(supply);
			}

		}

		return supplies;
	}

	@Override
	public void insertSupply(Supply supply) throws SQLException {
		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("insert into supply values(null,?,?,?,?)");

		) {
			ps.setInt(1, supply.getProductId());
			ps.setInt(2, supply.getAmount());
			ps.setDouble(3, supply.getUnitPrice());
			ps.setLong(4, supply.getDate());
			ps.executeUpdate();

		}

	}

	@Override
	public void removeSupply(Supply supply) throws SQLException {
		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("delete from supply where id = ?");

		) {
			ps.setInt(1, supply.getId());
			ps.executeUpdate();

		}

	}

	@Override
	public void updateSupply(Supply supply) throws SQLException {
		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement(
						"update supply set product_id = ? , amount = ? , unit_price = ? , date = ? " + " where id = ?");

		) {
			ps.setInt(1, supply.getProductId());
			ps.setInt(2, supply.getAmount());
			ps.setDouble(3, supply.getUnitPrice());
			ps.setLong(4, supply.getDate());
			ps.setInt(5, supply.getId());
			ps.executeUpdate();
		}

	}

	@Override
	public List<Expediture> getAllExpediture() throws SQLException {
		List<Expediture> expeditures = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("select * from expediture")) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Expediture expediture = new Expediture(rs.getInt("id"), rs.getInt("product_id"), rs.getInt("amount"),
						rs.getLong("date"));
				expeditures.add(expediture);

			}

		}

		return expeditures;
	}

	@Override
	public void insertExpediture(Expediture expediture) throws SQLException {
		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("insert into expediture values(null,?,?,?)");

		) {
			ps.setInt(1, expediture.getProductId());
			ps.setInt(2, expediture.getAmount());
			ps.setLong(3, expediture.getDate());
			ps.executeUpdate();

		}

	}

	@Override
	public void removeExpediture(Expediture expediture) throws SQLException {
		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement("delete from expediture where id = ?");

		) {
			ps.setInt(1, expediture.getId());
			ps.executeUpdate();

		}
	}

	@Override
	public void updateExpediture(Expediture expediture) throws SQLException {
		try (Connection con = DriverManager.getConnection(db);
				PreparedStatement ps = con.prepareStatement(
						"update expediture set product_id = ? , amount = ?  date = ? " + " where id = ?");

		) {
			ps.setInt(1, expediture.getProductId());
			ps.setInt(2, expediture.getAmount());
			ps.setLong(3, expediture.getDate());
			ps.setInt(4, expediture.getId());
			ps.executeUpdate();
		}

	}

}
