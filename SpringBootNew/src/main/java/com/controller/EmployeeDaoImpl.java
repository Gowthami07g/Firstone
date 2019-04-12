package com.controller;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoIntf {
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveDetails(Employee emp) {
		
		entityManager.persist(emp);

	}

	@Override
	public List<Employee> showList() {

		return entityManager.createQuery("from Employee").getResultList();
	}

	
	@Override
	public void deleteById(int id) {
		entityManager.createNativeQuery("delete from newemployee where emp_no=?").setParameter(1, id).executeUpdate();
	}

	@Override
	public int editById(int id1) {
		
		Query query  = entityManager.createQuery("from Employee where empNo =?");
		query.setParameter(1,id1);
		List<Employee> resultUser = query.getResultList();
		Iterator itr = resultUser.iterator();
		Employee employee = null;
		while (itr.hasNext()) {
			employee = (Employee) itr.next();
		}
		if (resultUser.size() != 0) {
			return employee.getEmpNo();
		} else {
			return 0;

		}
	}

	@Override
	public Employee update(Employee emp) {
       Query query=entityManager.createNativeQuery("update newemployee set emp_name=?,city=?,phnoe=? where emp_no=? ");
       
            query.setParameter(1,emp.getEmpName());
            query.setParameter(2, emp.getCity());
            query.setParameter(3, emp.getPhnoe());
           query.setParameter(4,emp.getEmpNo());
            
            query.executeUpdate();
        return emp;
	}
}

	/*@Override
	public void deleteById(int id) {
		sessionfactory.getCurrentSession().createSQLQuery("delete from employee where empNo=?")
				.addEntity(Employee.class).setParameter(0, id).executeUpdate();
	}

	@Override
	public int editById(int id1) {
		String hql = "select * from employee where empNo='" + id1 + "'";
		SQLQuery query = sessionfactory.getCurrentSession().createSQLQuery(hql).addEntity(Employee.class);
		List resultUser = query.list();
		Iterator itr = resultUser.iterator();
		Employee employee = null;
		while (itr.hasNext()) {
			employee = (Employee) itr.next();
		}
		if (resultUser.size() != 0) {
			return employee.getEmpNo();
		} else {
			return 0;

		}
	
	}

	@Override
	public Employee update(Employee emp, int a) {
        Session session=sessionfactory.getCurrentSession();
        SQLQuery query=session.createSQLQuery("update employee set empName=?,city=?,phnoe=? where empNo=? ").addEntity(Employee.class);
            query.setParameter(0,emp.getEmpName());
            query.setParameter(1, emp.getCity());
            query.setParameter(2, emp.getPhnoe());
            query.setParameter(3, a);
            
            query.executeUpdate();
        return emp;
	}

}
*/