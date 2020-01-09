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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import edu201906.common.page.PaginationResult;
import edu201906.spring.domain.ChartInfo;
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

	@RequestMapping(value = "/chart/{cid}", method = RequestMethod.GET)
	@ResponseBody
	public List<ChartInfo> getNationDist(@PathVariable Integer cid) {
		return playerService.getNationDist(cid);
	}

	@RequestMapping(value = "/chartMain/{cid}", method = RequestMethod.GET)
	public String getChartById(@PathVariable Integer cid, ModelMap modelMap) {
		List<ChartInfo> list = playerService.getNationDist(cid);
		modelMap.put("list", JSON.toJSONString(list));

		modelMap.put("list2", JSON.toJSONString(playerService.getPlayerWageJson(cid)));
		return "chart";
	}

	public static void main(String[] args) {
		JSONArray j1 = new JSONArray();
		j1.add(10);
		j1.add(8);
		JSONArray j2 = new JSONArray();
		j2.add(20);
		j2.add(16);

		JSONArray j0 = new JSONArray();
		j0.add(j1);
		j0.add(j2);

		System.out.println(j0);
		String s = j0.toString();
		s = s.substring(1, s.length() - 1);
		System.out.println(s);
		/*
		 * Examples:
		 * 
		 * "hamburger".substring(4, 8) returns "urge" 
		 * 
		 * "smiles".substring(1, 5) returns
		 * "mile"
		 */

	}
}
