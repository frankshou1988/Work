package com.tetrapak.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.tetrapak.hibernate.HU;

/**
 * Class to provide the basic create, update, saveOrupdate,and delete for
 * persistent objects
 * */
public class CommonDao {
    /**
     * Create an object
     * */
    public static Boolean save(Object objToSave) throws Exception {
	Boolean result = false;
	Session s = null;
	Transaction t = null;
	try {
	    SessionFactory sf = HU.getSessionFactory();
	    s = sf.openSession();
	    t = s.beginTransaction();
	    s.save(objToSave);
	    t.commit();
	    result = true;
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return result;
    }

    /**
     * Update an object
     * */
    public static Boolean update(Object objToUpdate) throws Exception {
	Boolean result = false;
	Session s = null;
	Transaction t = null;
	try {
	    SessionFactory sf = HU.getSessionFactory();
	    s = sf.openSession();
	    t = s.beginTransaction();
	    s.update(objToUpdate);
	    t.commit();
	    result = true;
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return result;
    }

    /**
     * Save or update an object
     * */
    public static Boolean saveOrUpdate(Object objToSaveOrUpdate) throws Exception {
	Boolean result = false;
	Session s = null;
	Transaction t = null;
	try {
	    SessionFactory sf = HU.getSessionFactory();
	    s = sf.openSession();
	    t = s.beginTransaction();
	    s.saveOrUpdate(objToSaveOrUpdate);
	    t.commit();
	    result = true;
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return result;
    }

    /**
     * Delete an object
     * */
    public static Boolean delete(Object objToDelete) throws Exception {
	Boolean result = false;
	Session s = null;
	Transaction t = null;
	try {
	    SessionFactory sf = HU.getSessionFactory();
	    s = sf.openSession();
	    t = s.beginTransaction();
	    s.delete(objToDelete);
	    t.commit();
	    result = true;
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return result;
    }

    public static Object getObjById(Class<?> classType, Integer id) throws Exception {
	Object obj = null;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    List<?> objList = s.createCriteria(classType).add(Restrictions.idEq(id)).list();
	    t.commit();
	    if (objList.size() > 0) {
		obj = objList.get(0);
	    }
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return obj;
    }

    public static Object getObjByColumns(Class<?> classType, String[] columnNames, Object[] columnValues)
	    throws Exception {
	Object obj = null;
	if (columnNames.length == 0 || columnNames.length != columnValues.length) {
	    throw new Exception("column count zero error or unmatch column values pairs.");
	}
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(classType);
	    int size = columnNames.length;
	    for (int i = 0; i < size; i++) {
		String columnName = columnNames[i];
		Object columnValue = columnValues[i];
		c.add(Restrictions.eq(columnName, columnValue));
	    }
	    c.setMaxResults(1);
	    List<?> objList = c.list();
	    t.commit();
	    if (objList.size() > 0) {
		obj = objList.get(0);
	    }
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return obj;
    }

    public static List<?> getAllObjByColumns(Class<?> classType, String[] columnNames, Object[] columnValues,
	    String orderColumnName, Boolean asc) throws Exception {
	List<?> objList = null;
	if (columnNames.length == 0 || columnNames.length != columnValues.length) {
	    throw new Exception("column count zero error or unmatch column values pairs.");
	}
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(classType);
	    int size = columnNames.length;
	    for (int i = 0; i < size; i++) {
		String columnName = columnNames[i];
		Object columnValue = columnValues[i];
		c.add(Restrictions.eq(columnName, columnValue));
	    }
	    if (orderColumnName != null) {
		if (asc) {
		    c.addOrder(Order.asc(orderColumnName));
		} else {
		    c.addOrder(Order.desc(orderColumnName));
		}
	    }
	    objList = c.list();
	    t.commit();

	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return objList;
    }

    public static Object getObjByColumns(Class<?> classType, String[] columnNames, Object[] columnValues,
	    String orderColumnName, Boolean asc) throws Exception {
	Object obj = null;
	if (columnNames.length == 0 || columnNames.length != columnValues.length) {
	    throw new Exception("column count zero error or unmatch column values pairs.");
	}
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(classType);
	    int size = columnNames.length;
	    for (int i = 0; i < size; i++) {
		String columnName = columnNames[i];
		Object columnValue = columnValues[i];
		c.add(Restrictions.eq(columnName, columnValue));
	    }
	    if (orderColumnName != null) {
		if (asc) {
		    c.addOrder(Order.asc(orderColumnName));
		} else {
		    c.addOrder(Order.desc(orderColumnName));
		}
	    }
	    c.setMaxResults(1);
	    List<?> objList = c.list();
	    t.commit();
	    if (objList.size() > 0) {
		obj = objList.get(0);
	    }
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return obj;
    }

    public static List<?> getAllObjByColumnsAndRef(Class<?> classType, String[] columnNames, Object[] columnValues,
	    String refColumnName, String refClassColumnName, Object refColumnValue, String orderColumnName, Boolean asc)
	    throws Exception {
	List<?> objList = null;
	if (columnNames.length != columnValues.length) {
	    throw new Exception("column count zero error or unmatch column values pairs.");
	}
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(classType);
	    int size = columnNames.length;
	    for (int i = 0; i < size; i++) {
		String columnName = columnNames[i];
		Object columnValue = columnValues[i];
		c.add(Restrictions.eq(columnName, columnValue));
	    }
	    c.createCriteria(refColumnName).add(Restrictions.eq(refClassColumnName, refColumnValue));
	    if (orderColumnName != null) {
		if (asc) {
		    c.addOrder(Order.asc(orderColumnName));
		} else {
		    c.addOrder(Order.desc(orderColumnName));
		}
	    }
	    objList = c.list();
	    t.commit();

	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return objList;
    }

    public static Object getObjByColumnsAndRef(Class<?> classType, String[] columnNames, Object[] columnValues,
	    String refColumnName, String refClassColumnName, Object refColumnValue) throws Exception {
	Object obj = null;
	if (columnNames.length != columnValues.length) {
	    throw new Exception("column count zero error or unmatch column values pairs.");
	}
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(classType);
	    int size = columnNames.length;
	    for (int i = 0; i < size; i++) {
		String columnName = columnNames[i];
		Object columnValue = columnValues[i];
		c.add(Restrictions.eq(columnName, columnValue));
	    }
	    c.createCriteria(refColumnName).add(Restrictions.eq(refClassColumnName, refColumnValue));
	    c.setMaxResults(1);
	    List<?> objList = c.list();
	    if (objList.size() > 0) {
		obj = objList.get(0);
	    }
	    t.commit();
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return obj;
    }

    public static List<?> getAllObj(Class<?> classType, String orderColumnName, Boolean asc) throws Exception {
	List<?> objList = null;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(classType);
	    if (orderColumnName != null) {
		if (asc) {
		    c.addOrder(Order.asc(orderColumnName));
		} else {
		    c.addOrder(Order.desc(orderColumnName));
		}
	    }
	    objList = c.list();
	    t.commit();
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return objList;
    }

    public static Object getObjByUniqueColumn(Class<?> classType, String columnName, Object columnValue)
	    throws Exception {
	Object result = null;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(classType).add(Restrictions.eq(columnName, columnValue));
	    List<?> objList = c.list();
	    if (objList.size() > 0) {
		result = objList.get(0);
	    }
	    t.commit();
	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return result;
    }

    public static List<?> checkObjDuplicate(Class<?> classType, String andColumnName, Object andColumnValue,
	    String orColumnName1, Object orColumnValue1, String orColumnName2, Object orColumnValue2) throws Exception {
	List<?> objList = null;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(classType);
	    c.add(Restrictions.eq(andColumnName, andColumnValue));
	    c.add(Restrictions.or(Restrictions.eq(orColumnName1, orColumnValue1),
		    Restrictions.eq(orColumnName2, orColumnValue2)));
	    c.setMaxResults(1);

	    objList = c.list();
	    t.commit();

	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return objList;
    }

    public static List<?> checkObjDuplicate(Class<?> classType, String andColumnName1, Object andColumnValue1,
	    String andColumnName2, Object andColumnValue2, String orColumnName1, Object orColumnValue1,
	    String orColumnName2, Object orColumnValue2) throws Exception {
	List<?> objList = null;
	SessionFactory sf = HU.getSessionFactory();
	Session s = sf.openSession();
	Transaction t = null;
	try {
	    t = s.beginTransaction();
	    Criteria c = s.createCriteria(classType);
	    c.add(Restrictions.eq(andColumnName1, andColumnValue1));
	    c.add(Restrictions.eq(andColumnName2, andColumnValue2));
	    c.add(Restrictions.or(Restrictions.eq(orColumnName1, orColumnValue1),
		    Restrictions.eq(orColumnName2, orColumnValue2)));
	    c.setMaxResults(1);

	    objList = c.list();
	    t.commit();

	} catch (Exception e) {
	    if (t != null) {
		t.rollback();
	    }
	    throw e;
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
	return objList;
    }
}
