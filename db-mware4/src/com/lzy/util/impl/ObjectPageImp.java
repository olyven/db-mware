package com.lzy.util.impl;

import com.lzy.util.ObjectPage;

public class ObjectPageImp<T> extends ObjectListImp<T> implements ObjectPage<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 527345202648295081L;
	private int page=1;
	private int pages=1;
	private int total=0;
	private int max=1;
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public void setTotal(int total){
		this.total = total;
	}
	public void setPages(int pages){
		this.pages = pages;
	}
	public void setPage(int page){
		this.page = page;
	}

	public int pages() {
		// TODO Auto-generated method stub
		return pages;
	}

	public int pageId() {
		// TODO Auto-generated method stub
		return page;
	}

	public boolean hasNextPage() {
		// TODO Auto-generated method stub
		return page>=pages;
	}

	public boolean hasPrevPage() {
		// TODO Auto-generated method stub
		return page>0;
	}

	public int total() {
		// TODO Auto-generated method stub
		return total;
	}
}
