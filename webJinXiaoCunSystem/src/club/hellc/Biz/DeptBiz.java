package club.hellc.Biz;

import java.util.List;

import club.hellc.Dao.DeptDaoImpl;
import club.hellc.pojo.Dept;

public class DeptBiz {
	DeptDaoImpl dDao = new DeptDaoImpl();

	public int add(Dept pro) {
		return dDao.add(pro);
	}

	public int deleteById(Integer id) {
		return dDao.deleteById(id);
	}

	public int updateById(Dept pro) {
		return dDao.updateById(pro);
	}

	public Dept findById(Integer id) {
		return dDao.findById(id);
	}

	public List<Dept> findAll() {
		return dDao.findAll();
	}

	public Dept findByName(String name) {
		return dDao.findByName(name);
	}
}
