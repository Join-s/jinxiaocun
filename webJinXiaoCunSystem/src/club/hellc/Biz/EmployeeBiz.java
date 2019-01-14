package club.hellc.Biz;

import java.util.List;

import club.hellc.Dao.EmployeeDaoImpl;
import club.hellc.pojo.Employee;

public class EmployeeBiz {
	EmployeeDaoImpl eeDao = new EmployeeDaoImpl();

	public int add(Employee ee) {
		return eeDao.add(ee);
	}

	public int deleteById(Integer id) {
		return eeDao.deleteById(id);
	}

	public int updateById(Employee ee) {
		return eeDao.updateById(ee);
	}

	public Employee findById(Integer id) {
		return eeDao.findById(id);
	}

	public List<Employee> findAll() {
		return eeDao.findAll();
	}

	public int getCountsOfRow(Integer row) {

		return eeDao.getCountsOfRow(row);
	}

	public List<Employee> findAll(Integer currPage, Integer row) {
		return eeDao.findAll(currPage, row);
	}
}
