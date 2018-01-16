package model;

public class Expediture {

	private Integer id;
	private Integer productId;
	private Integer amount;
	private Long  date;

	public Expediture(Integer id, Integer productId, Integer amount, Long  date) {
		super();
		this.id = id;
		this.productId = productId;
		this.amount = amount;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Long  getDate() {
		return date;
	}

	public void setDate(Long  date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Expediture [id=" + id + ", productId=" + productId + ", amount=" + amount + ", date=" + date + "]";
	}

}
