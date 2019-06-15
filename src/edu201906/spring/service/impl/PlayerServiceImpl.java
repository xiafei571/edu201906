package edu201906.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
