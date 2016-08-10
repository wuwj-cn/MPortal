package com.moke.core.tree.service;

import java.util.List;

public interface TreeService {
	/**
	 * Return children of the given node id.
	 * 
	 * @param id parent node id
	 * @param href
	 * @param hrefTarget
	 * @return  list of TreeNode
	 */
	public List getNodes(String id, String href, String hrefTarget);

	/**
	 * Return children with checkbox of the given node id.
	 * 
	 * @param id parent node id
	 * @param href
	 * @param hrefTarget
	 * @return  list of CheckboxTreeNode
	 */
	public List getCheckboxNodes(String id, String href, String hrefTarget);
}
