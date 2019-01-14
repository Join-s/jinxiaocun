package club.hellc.Biz;

import java.util.List;

import club.hellc.Dao.ProducttypeDaoImpl;
import club.hellc.pojo.Producttype;

public class ProducttypeBiz {

	ProducttypeDaoImpl protypeDao = new ProducttypeDaoImpl();

	public int add(Producttype protype) {
		return protypeDao.add(protype);
	}

	public int deleteById(Integer id) {
		return protypeDao.deleteById(id);
	}

	public int updateById(Producttype protype) {
		return protypeDao.updateById(protype);
	}

	public Producttype findById(Integer id) {
		return protypeDao.findById(id);
	}

	public List<Producttype> findAll() {
		return protypeDao.findAll();
	}

	public int findByName(String name) {
		return protypeDao.findByName(name);
	}

	public int getCountsOfRow(Integer row) {
		return protypeDao.getCountsOfRow(row);
	}

	public List<Producttype> findAll(Integer curPage, Integer row) {
		return protypeDao.findAll(curPage, row);

	}
}
