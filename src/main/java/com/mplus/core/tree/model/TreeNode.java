package com.mplus.core.tree.model;


public class TreeNode {
	protected String id;
	protected String text;
	protected boolean expanded;
	protected boolean leaf;

	public TreeNode() {
	}

	public TreeNode(String id, String text, boolean expanded, boolean leaf) {
		super();
		this.id = id;
		this.text = text;
		this.expanded = expanded;
		this.leaf = leaf;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

}
