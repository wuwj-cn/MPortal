package com.mplus.MPortal.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mplus.MPortal.model.Menu;
import com.mplus.MPortal.service.MenuService;
import com.mplus.core.advice.Result;
import com.mplus.core.tree.model.TreeNode;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/menus")
public class MenuController {
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list() {
		Iterable<Menu> list = menuService.findAll();
		return Result.sucess(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result get(@PathVariable String id) {
		Menu menu = menuService.findOne(id);
		return Result.sucess(menu);
	}
	
	@RequestMapping(value = "/tree/{id}", method = RequestMethod.GET)
	public Result getMenuTree(@PathVariable String id) {
		Menu menu = menuService.findOne(id);
		TreeNode node = new TreeNode(menu.getId(), menu.getName(), false, false);
		return Result.sucess(node);
	}
	
	@RequestMapping(value = "/tree/children/{parentCode}", method = RequestMethod.GET)
	public Result getMenuTreeByParentCode(@PathVariable String parentCode) {
		List<TreeNode> nodes = menuService.findChildren(parentCode);
		return Result.sucess(nodes);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Result create(@RequestBody Menu menu) {
		menuService.save(menu);
		return Result.sucess(menu);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable Long id, @RequestBody Menu menu) {
		if(!id.equals(menu.getId())) {
			logger.warn("9001", "指定对象ID不匹配");
			return Result.failure("9001");
		}
		menuService.save(menu);
		return Result.sucess(menu);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		Menu menu = menuService.findOne(id);
		if(null == menu) {
			logger.warn("9002", "指定对象不存在");
			return Result.failure("9002");
		}
		return Result.sucess(menu);
	}
}
