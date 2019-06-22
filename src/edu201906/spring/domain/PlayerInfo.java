package edu201906.spring.domain;

public class PlayerInfo {
	// 序列
	private Integer rowid;
	// 球员ID
	private Integer pid;
	// 球员名词
	private String pname;
	// 球员照片
	private String photo;
	// 俱乐部ID
	private Integer cid;
	// 国籍ID
	private Integer nid;
	// 能力值
	private Integer overall;
	//俱乐部信息
	private ClubInfo club;
	//国家信心
	private NationInfo nation;

	public ClubInfo getClub() {
		return club;
	}

	public void setClub(ClubInfo club) {
		this.club = club;
	}

	public NationInfo getNation() {
		return nation;
	}

	public void setNation(NationInfo nation) {
		this.nation = nation;
	}

	public Integer getRowid() {
		return rowid;
	}

	public void setRowid(Integer rowid) {
		this.rowid = rowid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public Integer getOverall() {
		return overall;
	}

	public void setOverall(Integer overall) {
		this.overall = overall;
	}

	@Override
	public String toString() {
		return "PlayerInfo [rowid=" + rowid + ", pid=" + pid + ", pname=" + pname + ", photo=" + photo + ", cid=" + cid
				+ ", nid=" + nid + ", overall=" + overall + "]";
	}

	public PlayerInfo(Integer rowid, Integer pid, String pname, String photo, Integer cid, Integer nid,
			Integer overall) {
		super();
		this.rowid = rowid;
		this.pid = pid;
		this.pname = pname;
		this.photo = photo;
		this.cid = cid;
		this.nid = nid;
		this.overall = overall;
	}

	public PlayerInfo() {
	}
}
