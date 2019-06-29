package edu201906.spring.domain;

public class DrinkInfo {
	// 饮料号码
	private Integer drink_kind_num;
	// 饮料价格
	private Integer price;
	// 存量
	private Integer quantity;
	// 饮料名词
	private String drink_name;
	// 饮料类型 0 冷饮， 1 热饮
	private Integer type;

	public Integer getDrink_kind_num() {
		return drink_kind_num;
	}

	public void setDrink_kind_num(Integer drink_kind_num) {
		this.drink_kind_num = drink_kind_num;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDrink_name() {
		return drink_name;
	}

	public void setDrink_name(String drink_name) {
		this.drink_name = drink_name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DrinkInfo [drink_kind_num=" + drink_kind_num + ", price=" + price + ", quantity=" + quantity
				+ ", drink_name=" + drink_name + ", type=" + type + "]";
	}

	public DrinkInfo(Integer drink_kind_num, Integer price, Integer quantity, String drink_name, Integer type) {
		super();
		this.drink_kind_num = drink_kind_num;
		this.price = price;
		this.quantity = quantity;
		this.drink_name = drink_name;
		this.type = type;
	}

	public DrinkInfo() {
	}

}
