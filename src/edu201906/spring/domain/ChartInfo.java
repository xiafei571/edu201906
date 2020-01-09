package edu201906.spring.domain;

public class ChartInfo {

	private Integer id;
	
	private String name;
	
	private Integer value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "{name=" + name + ", value=" + value + "}";
	}
	
	
}
