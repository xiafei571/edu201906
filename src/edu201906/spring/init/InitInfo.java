package edu201906.spring.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu201906.spring.domain.ClubInfo;
import edu201906.spring.domain.NationInfo;
import edu201906.spring.model.mapper.PlayerMapper;

@Component
public class InitInfo implements InitializingBean {
	@Autowired
	private PlayerMapper playerMapper;

	public static Map<Integer, ClubInfo> club = new HashMap<Integer, ClubInfo>();

	public static Map<Integer, NationInfo> nation = new HashMap<Integer, NationInfo>();

	private void initClub() {
		List<ClubInfo> clubList = playerMapper.getClubList();
		System.out.println("俱乐部数据初始化，数量" + clubList.size());
		for (ClubInfo clubInfo : clubList) {
			club.put(clubInfo.getCid(), clubInfo);
		}
	}

	private void initNation() {
		List<NationInfo> nationList = playerMapper.getNationList();
		System.out.println("国家数据初始化，数量" + nationList.size());
		for (NationInfo nationInfo : nationList) {
			nation.put(nationInfo.getNid(), nationInfo);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("初始化俱乐部信息开始");
		initClub();
		System.out.println("初始化国家信息开始");
		initNation();
	}
}
