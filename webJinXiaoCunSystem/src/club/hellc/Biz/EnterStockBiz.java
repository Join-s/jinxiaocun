package club.hellc.Biz;

import java.util.List;

import club.hellc.Dao.EnterStockDaoImpl;
import club.hellc.pojo.Enterstock;

public class EnterStockBiz {
	EnterStockDaoImpl esdao = new EnterStockDaoImpl();

	public int add(Enterstock es) {
		return esdao.add(es);

	}

	public int deleteById(Integer id) {
		return esdao.deleteById(id);

	}

	public int updateById(Enterstock es) {
		return esdao.updateById(es);

	}

	public Enterstock findById(Integer id) {
		return esdao.findById(id);

	}

	public List<Enterstock> findAll() {
		return esdao.findAll();

	}

	public List<Enterstock> findAllByProName(String proname) {
		return esdao.findAllByProName(proname);
	}

	public List<Enterstock> findAll(Integer curPage, Integer row) {
		return esdao.findAll(curPage, row);
	}

	public int getCountsOfRow(Integer row) {
		return esdao.getCountsOfRow(row);
	}

	public List<Enterstock> findAllBytime(String time) {
		return esdao.findAllBytime(time);
	}
}
