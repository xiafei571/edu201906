package edu201906.spring.service;

import java.util.List;

import edu201906.common.page.PaginationResult;
import edu201906.spring.domain.PlayerInfo;

public interface PlayerService {
	/**
	 * 通过ID 查询球员
	 * 
	 * @param id
	 * @return
	 */
	PlayerInfo getPlayer(Integer id);

	/**
	 * 查询球员列表
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	PaginationResult<List<PlayerInfo>> getPlayerList(Integer pageIndex, Integer pageSize);
}
