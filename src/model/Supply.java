package model;

public class Supply {

	private Integer id;
	private Integer productId;
	private Integer amount;
	private Double unitPrice;
	private Long date;

	public Supply(Integer id, Integer productId, Integer amount, Double unitPrice, Long date) {
		super();
		this.id = id;
		this.productId = productId;
		this.amount = amount;
		this.unitPrice = unitPrice;
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

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Supply [id=" + id + ", productId=" + productId + ", amount=" + amount + ", unitPrice=" + unitPrice
				+ ", date=" + date + "]";
	}

}
