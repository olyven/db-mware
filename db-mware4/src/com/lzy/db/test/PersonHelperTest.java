package com.lzy.db.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lzy.db.or.WritableHelper;
import com.lzy.db.orderby.DescOrder;
import com.lzy.db.orderby.OrderByExpression;
import com.lzy.db.session.DBSession;
import com.lzy.db.session.SessionFactory;
import com.lzy.util.ObjectList;

public class PersonHelperTest {
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		DBSession session = SessionFactory.createLDBSession("jdbc:mysql://127.0.0.1/test?user=root&password=olyven");
		
		Person person = new Person();
		person.setName("lzy");
		person.setSex(1);
		person.setBirthday(new Date());
		try{
			session.open();
			WritableHelper personHelper = new WritableHelper(new PersonObject());
			long id = personHelper.create(session,person);
			Assert.assertFalse(id==0);
			Person p3 = (Person)personHelper.findByKey(session,id);
			Assert.assertTrue(p3!=null);
			Assert.assertEquals(p3.getName(),person.getName());
			p3.setName("olyven");
			personHelper.modify(session,p3);
			Person p4 = (Person)personHelper.findByKey(session,id);
			Assert.assertEquals(p4.getName(), p3.getName());
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2011);
			cal.set(Calendar.MONTH, 8);
			Date d = cal.getTime();
			p4.setBirthday(d);
			cal.setTime(p4.getBirthday());
			Assert.assertEquals(cal.get(Calendar.YEAR), 2011);
			Assert.assertEquals(cal.get(Calendar.MONTH), 8);
			personHelper.modify(session,p4);
			Person p5 = (Person)personHelper.findByKey(session,id);
			cal.setTime(p5.getBirthday());
			Assert.assertEquals(cal.get(Calendar.YEAR), 2011);
			Assert.assertEquals(cal.get(Calendar.MONTH), 8);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	@Test
	public void test2(){
		DBSession session = SessionFactory.createLDBSession("jdbc:mysql://127.0.0.1/test?user=root&password=olyven");
		OrderByExpression obe = new OrderByExpression();
		obe.add(new DescOrder("id"));
		try{
			session.open();
			WritableHelper personHelper = new WritableHelper(new PersonObject());
			@SuppressWarnings("unchecked")
			ObjectList<Person> persons = personHelper.list(session,null,obe);
			if(persons.size()>1)
			Assert.assertTrue(persons.get(0).getId()>persons.get(1).getId());
			//Assert.assertTrue(107==persons.get(1).getId());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
