package com.lzy.db.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzy.db.exception.OperationException;
import com.lzy.db.session.DBSession;
import com.lzy.db.table.IRecordFetcher;
import com.lzy.util.ObjectList;
import com.lzy.util.ObjectPage;
import com.lzy.util.impl.ObjectListImp;
import com.lzy.util.impl.ObjectPageImp;

public class SQLExecuteTool {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObjectList sqlSearch(DBSession session, IRecordFetcher fetcher, String sql)throws OperationException{
		ObjectList ol = new ObjectListImp();
		try{
			ResultSet rs = session.query(sql);
			for(; rs.next(); ){
				ol.add(fetcher.fetch(rs));
			}
			return ol;
		}catch(SQLException e){
			throw new OperationException(e.getMessage());
		}finally{
			session.realse();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ObjectPage sqlSearch(DBSession session, IRecordFetcher fetcher, int page, int max, String sql)throws OperationException{
		if(max<1 || page<1){throw new OperationException("页数和最大记录数为非法值");}
		int start = (page-1)*max+1;
		ObjectPage op = new ObjectPageImp();
		try{
			ResultSet rs = session.query(sql);
			if(rs.last()){	//如果数据，并移到最后一行记录上
				int count = rs.getRow();	//获取最后一条记录号，作为当前总记录数
				op.setTotal(count);	//设置总条数
				op.setMax(max);	//设置最多条数
				op.setPages(op.total()%max!=0?op.total()/max+1:op.total()/max);
				int i=0;
				if(count>start){ //如果起始位置有数据可取，则取可获取得到的数据
					rs.absolute(start);
					op.setPage(page);
					do{
						op.add(fetcher.fetch(rs));
						++i;
					}while(rs.next()&&i<max);
				}else if(count>max){	//如果起始位无数据可取，且记录条数多于每页最大数，则取最后一页数据
					page = op.pages();
					op.setPage(page);
					start = (page-1)*max+1;
					rs.absolute(start);
					do{
						op.add(fetcher.fetch(rs));
						++i;
					}while(rs.next()&&i<max);
				}else{	//如果起始位无数据可取，且记录条数小于每页最大数，则取第一页数据
					op.setPage(1);
					rs.first();
					do{
						op.add(fetcher.fetch(rs));
						++i;
					}while(rs.next());
				}
			}
			return op;
		}catch(SQLException e){
			throw new OperationException(e.getMessage());
		}finally{
			session.realse();
		}
	}
	
	public Object find(DBSession session, IRecordFetcher fetcher, String sql) throws OperationException {
		// TODO Auto-generated method stub
		try{
			ResultSet rs = session.query(sql);
			Object po = null;
			if(rs.next()){
				po = fetcher.fetch(rs);
			}
			return po;
		}catch(SQLException e){
			throw new OperationException(e.getMessage());
		}finally{
			session.realse();
		}
	}
	
	public void execute(DBSession session, String sql)throws OperationException{
		try{
			session.execute(sql);
		}catch(SQLException e){
			throw new OperationException(e.getMessage());
		}finally{
			session.realse();
		}
	}
}
