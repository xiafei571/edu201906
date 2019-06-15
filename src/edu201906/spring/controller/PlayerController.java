package edu201906.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu201906.spring.domain.PlayerInfo;
import edu201906.spring.service.PlayerService;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PlayerInfo getPlayer(@PathVariable Integer id) {
		PlayerInfo player = playerService.getPlayer(id);
		return player;
	}
}
