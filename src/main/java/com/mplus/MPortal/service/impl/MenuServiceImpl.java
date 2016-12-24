package com.mplus.MPortal.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mplus.MPortal.model.Menu;
import com.mplus.MPortal.repository.MenuRepository;
import com.mplus.MPortal.service.MenuService;
import com.mplus.core.service.BaseServiceImpl;
import com.mplus.core.tree.model.TreeNode;

@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu, String> implements MenuService {

	@Autowired private MenuRepository menuRepository;
	
	public List<TreeNode> findChildren(String parentId) {
		List<Menu> children = menuRepository.findChildren(parentId);
		Iterator<Menu> it = children.iterator();
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		TreeNode node = null;
		Menu menu = null;
		while(it.hasNext()) {
			menu = it.next();
			node = new TreeNode(menu.getId(), menu.getCode(), menu.getName(), false, false);
			nodes.add(node);
		}
		return nodes;
	}
}
