package club.hellc.Biz;

import java.util.List;

import club.hellc.Dao.StorehouseDaoImpl;
import club.hellc.pojo.Storehouse;

public class StorehouseBiz {
	StorehouseDaoImpl shDao = new StorehouseDaoImpl();

	public int add(Storehouse protype) {
		return shDao.add(protype);
	}

	public int deleteById(Integer id) {
		return shDao.deleteById(id);
	}

	public int updateById(Storehouse protype) {
		return shDao.updateById(protype);
	}

	public Storehouse findById(Integer id) {
		return shDao.findById(id);
	}

	public List<Storehouse> findAll() {
		return shDao.findAll();
	}
}
