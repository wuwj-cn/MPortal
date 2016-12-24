package com.mplus.MPortal.service;

import java.util.List;

import com.mplus.MPortal.model.Menu;
import com.mplus.core.service.BaseService;
import com.mplus.core.tree.model.TreeNode;

public interface MenuService extends BaseService<Menu, String>{

	public List<TreeNode> findChildren(String parentId);
}
