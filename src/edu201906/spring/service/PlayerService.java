package edu201906.spring.service;

import edu201906.spring.domain.PlayerInfo;

public interface PlayerService {
	/**
	 * 通过ID 查询球员
	 * 
	 * @param id
	 * @return
	 */
	PlayerInfo getPlayer(Integer id);
}
