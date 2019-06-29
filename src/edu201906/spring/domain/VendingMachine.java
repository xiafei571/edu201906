package edu201906.spring.domain;

import java.util.List;
import java.util.Map;

public class VendingMachine {

	private Map<Integer, DrinkInfo> drinkMap;

	private List<Money> bankSaving;

	private Integer total_amount;

	private Integer total_deposit;

	public Map<Integer, DrinkInfo> getDrinkMap() {
		return drinkMap;
	}

	public void setDrinkMap(Map<Integer, DrinkInfo> drinkMap) {
		this.drinkMap = drinkMap;
	}

	public List<Money> getBankSaving() {
		return bankSaving;
	}

	public void setBankSaving(List<Money> bankSaving) {
		this.bankSaving = bankSaving;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public Integer getTotal_deposit() {
		return total_deposit;
	}

	public void setTotal_deposit(Integer total_deposit) {
		this.total_deposit = total_deposit;
	}

	@Override
	public String toString() {
		return "VendingMachine [drinkMap=" + drinkMap + ", total_amount=" + total_amount + ", total_deposit="
				+ total_deposit + "]";
	}
}
