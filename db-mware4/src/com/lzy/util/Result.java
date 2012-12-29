package com.lzy.util;

import com.lzy.util.ObjectList;
import com.lzy.util.ObjectPage;

public interface Result {
	public abstract int getId();

	public abstract String getMessage();

	public abstract <T> T getObject();

	public abstract <T> ObjectList<T> getObjectList();

	public abstract <T> ObjectPage<T> getObjectPage();

}