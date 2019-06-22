package edu201906.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu201906.common.page.PaginationResult;
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

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getPlayerList(ModelMap modelMap, Integer pageIndex, Integer pageSize) {
		String s = "index:" + pageIndex;
		modelMap.put("msg", s);
		
		String ss = "size:" + pageSize;
		modelMap.put("abc", ss);
		
		List<PlayerInfo> list = playerService.getPlayerList(pageSize);
		
//		PlayerInfo p1 = playerService.getPlayer(158023);
//		PlayerInfo p2 = playerService.getPlayer(183277);
//		list.add(p1);
//		list.add(p2);
		
		modelMap.put("list", list);
		
		return "index";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String deptList(HttpServletRequest request, ModelMap model, Integer pageIndex, Integer pageSize) {
		PaginationResult<List<PlayerInfo>> result = playerService.getPlayerList(pageIndex, pageSize);
		model.addAttribute("result", result);
		return "player";
	}
}
