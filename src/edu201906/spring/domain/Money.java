package edu201906.spring.domain;

public enum Money {

	COIN_5(5), COIN_10(10), COIN_50(50), COIN_100(100), BANK_TH(1000);

	private Integer amount;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	private Money(Integer amount) {
		this.amount = amount;
	}

	public static boolean contains(Integer amount) {
		for (Money money : Money.values()) {
			if (money.getAmount().equals(amount)) {
				return true;
			}
		}
		return false;
	}
}
