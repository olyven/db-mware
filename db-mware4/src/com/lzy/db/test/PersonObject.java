package com.lzy.db.test;

import com.lzy.db.table.TableObject;

public class PersonObject extends TableObject {
	public PersonObject() {
		super(Person.class.getName(), "person", "id");
		// TODO Auto-generated constructor stub
		addFieldAttr("id");
		addFieldAttr("name");
		addFieldAttr("sex");
		addFieldAttr("birthday");
	}
}
