package com.lzy.db.table;

import com.lzy.db.exception.OperationException;
import com.lzy.db.util.FieldValue;

public interface Object2FieldValue {
	FieldValue fieldValue(Object obj)throws OperationException;
}
