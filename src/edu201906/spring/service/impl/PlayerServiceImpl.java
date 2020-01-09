package edu201906.spring.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;

import edu201906.common.page.Pagination;
import edu201906.common.page.PaginationResult;
import edu201906.spring.domain.ChartInfo;
import edu201906.spring.domain.ClubInfo;
import edu201906.spring.domain.NationInfo;
import edu201906.spring.domain.PlayerInfo;
import edu201906.spring.init.InitInfo;
import edu201906.spring.model.mapper.PlayerMapper;
import edu201906.spring.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerMapper playerMapper;

	@Override
	public PlayerInfo getPlayer(Integer id) {
		PlayerInfo player = playerMapper.getPlayer(id);

		// 根据cid 去查俱乐部ClubInfo的信息
		ClubInfo club = playerMapper.getClub(player.getCid());
		player.setClub(club);

		// 根据nid 去查国家NationInfo信息
		NationInfo nation = playerMapper.getNation(player.getNid());
		player.setNation(nation);
		return player;
	}

	@Override
	public PaginationResult<List<PlayerInfo>> getPlayerList(Integer pageIndex, Integer pageSize) {
		Integer count = playerMapper.getPlayerCount();
		Pagination pagination = new Pagination(pageIndex, pageSize);
		pagination.setTotalCount(count);

		List<PlayerInfo> playerList = playerMapper.getPlayerPage(pagination.getCursor(), pagination.getOffset());
		for (PlayerInfo player : playerList) {
			player.setClub(InitInfo.club.get(player.getCid()));
			player.setNation(InitInfo.nation.get(player.getNid()));
		}

		PaginationResult<List<PlayerInfo>> result = new PaginationResult<List<PlayerInfo>>(pagination, playerList);
		return result;
	}

	@Override
	public List<PlayerInfo> getPlayerList(Integer pageSize) {
		if (null == pageSize)
			pageSize = 10;

		List<PlayerInfo> list = playerMapper.getPlayerList(pageSize);
		for (PlayerInfo p : list) {
			// 性能问题-循环差数据库
			// playerMapper.getClub(p.getCid())
			p.setClub(InitInfo.club.get(p.getCid()));
			// playerMapper.getNation(p.getNid())
			p.setNation(InitInfo.nation.get(p.getNid()));
		}

		return list;
	}

	@Override
	public List<ChartInfo> getNationDist(Integer cid) {
		List<ChartInfo> list = playerMapper.getNationDist(cid);
		for (ChartInfo chart : list) {
			chart.setName(InitInfo.nation.get(chart.getId()).getName());
		}
		return list;
	}

	@Override
	public JSONArray getPlayerWageJson(Integer cid) {
		//s.subString(1,s.length()-1);
		Pattern pattern = Pattern.compile("(\\d{1,5})");// (115).(5)

		List<PlayerInfo> list = playerMapper.getPlayerListByCid(cid);
		JSONArray result = new JSONArray();
		
		for (PlayerInfo player : list) {
			JSONArray json = new JSONArray();
			json.add(player.getOverall());
			
			Matcher matcher = pattern.matcher(player.getWage());
			while(matcher.find()) {
				json.add(matcher.group(1));
				result.add(json);
			}
		}
		
		System.out.println(result.toJSONString());
		return result;
	}

}
