package edu201906.spring.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu201906.spring.domain.DrinkInfo;
import edu201906.spring.domain.Money;
import edu201906.spring.domain.VendingMachine;

class MachineTest {

	@Test
	void test() {
		Map<Integer, DrinkInfo> drinkMap = initDrink();

		List<Money> moneyList = initMoney();

		Integer total_deposit = getTotalDeposit(moneyList);

		VendingMachine vm = initVM(drinkMap, moneyList, total_deposit);

		Integer total_amount = 0;

		payAction(drinkMap, vm, total_amount);
	}

	private void payAction(Map<Integer, DrinkInfo> drinkMap, VendingMachine vm, Integer total_amount) {
		total_amount = getAmount(total_amount);
		vm.setTotal_amount(total_amount);
		payProcess(drinkMap, vm, total_amount);
	}

	private void payProcess(Map<Integer, DrinkInfo> drinkMap, VendingMachine vm, Integer total_amount) {
		int temp;
		System.out.println(vm);
		System.out.println("请选择饮品：");
		Scanner sc2 = new Scanner(System.in);
		while (sc2.hasNextInt()) {
			temp = sc2.nextInt();
			if (drinkMap.containsKey(temp)) {
				System.out.println("选择" + drinkMap.get(temp).getDrink_name());
				// 判断钱是否够付款的
				if (total_amount >= drinkMap.get(temp).getPrice() && drinkMap.get(temp).getQuantity() > 0) {
					// 钱足够 且 饮料的剩余数>0
					System.out.println("退还金额：" + (total_amount - drinkMap.get(temp).getPrice()));
					// 贩卖机内该饮料数量-1
					vm.getDrinkMap().get(temp).setQuantity(vm.getDrinkMap().get(temp).getQuantity() - 1);
					// 贩卖机内剩余的钱
					vm.setTotal_deposit(vm.getTotal_deposit() + drinkMap.get(temp).getPrice());
				} else {
//					System.out.println("钱不够，全部退还");
//					total_amount = 0;
					System.out.println("钱不够");
					// 用递归
					payAction(drinkMap, vm, total_amount);
				}
				total_amount = 0;
				vm.setTotal_amount(total_amount);
				System.out.println(vm);
				break;
			} else {
				System.out.println("无效选项");
			}
		}
	}

	private Integer getAmount(Integer total_amount) {
		int temp;
		System.out.println("请投币");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			temp = sc.nextInt();
			if (Money.contains(temp)) {
				total_amount += temp;
			} else {
				System.out.println("未识别的货币");
			}
			System.out.println("当前金额:" + total_amount);
		}
		return total_amount;
	}

	private VendingMachine initVM(Map<Integer, DrinkInfo> drinkMap, List<Money> moneyList, Integer total_deposit) {
		VendingMachine vm = new VendingMachine();
		vm.setDrinkMap(drinkMap);
		vm.setBankSaving(moneyList);
		vm.setTotal_deposit(total_deposit);
		return vm;
	}

	private Integer getTotalDeposit(List<Money> moneyList) {
		Integer total_deposit = 0;
		for (Money money : moneyList) {
			total_deposit += money.getAmount();
		}
		return total_deposit;
	}

	private List<Money> initMoney() {
		List<Money> moneyList = new ArrayList<Money>();
		for (int i = 0; i < 20; i++) {
			moneyList.add(Money.COIN_5);
			moneyList.add(Money.COIN_10);
			moneyList.add(Money.COIN_50);
			moneyList.add(Money.COIN_100);
		}
		return moneyList;
	}

	private Map<Integer, DrinkInfo> initDrink() {
		Map<Integer, DrinkInfo> drinkMap = new HashMap<Integer, DrinkInfo>();

		DrinkInfo d1 = new DrinkInfo(1, 100, 9, "evian", 0);
		DrinkInfo d2 = new DrinkInfo(2, 110, 9, "cola", 0);
		DrinkInfo d3 = new DrinkInfo(3, 125, 9, "tea", 0);
		DrinkInfo d4 = new DrinkInfo(4, 145, 9, "juice", 0);

		drinkMap.put(d1.getDrink_kind_num(), d1);
		drinkMap.put(d2.getDrink_kind_num(), d2);
		drinkMap.put(d3.getDrink_kind_num(), d3);
		drinkMap.put(d4.getDrink_kind_num(), d4);
		return drinkMap;
	}

}
