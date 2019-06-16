package edu201906.spring.domain;

public class NationInfo {

	private Integer nid;
	
	private String name;
	
	private String flag;

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "NationInfo [nid=" + nid + ", name=" + name + ", flag=" + flag + "]";
	}
}
