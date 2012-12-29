package com.lzy.app.ui;

import com.lzy.app.bz.AbstractBz;
import com.lzy.util.Result;

public class AbstractUI {
	protected Result service(AbstractBz abz){
		return abz.service();
	}
}
