package com.lzy.util;

public interface ObjectPage<T> extends ObjectList<T> {
	int getMax();
	void setMax(int max);
	void setTotal(int total);
	void setPages(int pages);
	void setPage(int page);
	int pages();
	int pageId();
	boolean hasNextPage();
	boolean hasPrevPage();
	int total();
}
