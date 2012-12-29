package com.lzy.db.retrieve;

import com.lzy.db.exception.OperationException;
import com.lzy.db.session.DBSession;
import com.lzy.db.table.RelationshipObject;

public class RelationshipRetriever extends AbstractRetriever {
	private RelationshipObject rsObj;
	private long mKeyValue;
	public RelationshipRetriever(RelationshipObject rsObj, long mKeyValue) {
		super(rsObj.getScondaryTable());
		// TODO Auto-generated constructor stub
		this.rsObj = rsObj;
		this.mKeyValue = mKeyValue;
	}

	@Override
	public Object retrieve(DBSession session) throws OperationException {
		// TODO Auto-generated method stub
		return tool.sqlSearch(session, rsObj, sql());
	}

	@Override
	protected String sql() throws OperationException {
		// TODO Auto-generated method stub
		return sql.select(rsObj, mKeyValue);
	}

}
