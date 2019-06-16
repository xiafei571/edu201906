package edu201906.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu201906.spring.init.InitInfo;
import edu201906.common.page.Pagination;
import edu201906.common.page.PaginationResult;
import edu201906.spring.domain.PlayerInfo;
import edu201906.spring.model.mapper.PlayerMapper;
import edu201906.spring.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerMapper playerMapper;

	@Override
	public PlayerInfo getPlayer(Integer id) {
		return playerMapper.getPlayer(id);
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

}
