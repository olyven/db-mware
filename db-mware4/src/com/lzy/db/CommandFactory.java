package com.lzy.db;

import com.lzy.db.command.CreateCmd;
import com.lzy.db.command.DeleteCmd;
import com.lzy.db.command.UpdateCmd;
import com.lzy.db.express.ConditionExpression;
import com.lzy.db.table.TableObject;
import com.lzy.db.util.FieldValue;

public class CommandFactory {
	public ICommand create(TableObject tbObj, FieldValue fieldValue){
		return new CreateCmd(tbObj, fieldValue);
	}
	public ICommand create(TableObject tbObj, ConditionExpression cndt){
		return new DeleteCmd(tbObj, cndt);
	}
	public ICommand create(TableObject tbObj, FieldValue fieldValue, ConditionExpression cndt){
		return new UpdateCmd(tbObj, fieldValue, cndt);
	}
}
