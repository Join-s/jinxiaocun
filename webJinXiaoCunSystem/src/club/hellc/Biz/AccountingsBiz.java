package club.hellc.Biz;

import java.util.List;

import club.hellc.Dao.AccountingsDaoImpl;
import club.hellc.Dao.EnterStockDaoImpl;
import club.hellc.pojo.Accountings;
import club.hellc.pojo.Autoclass;

public class AccountingsBiz {
	AccountingsDaoImpl ad = new AccountingsDaoImpl();
	EnterStockDaoImpl es = new EnterStockDaoImpl();

	public int add(Accountings acc) {
		return ad.add(acc);
	}

	public int deleteById(Integer id) {
		return ad.deleteById(id);
	}

	public int updateById(Accountings acc) {
		return ad.updateById(acc);
	}

	public Accountings findById(Integer id) {
		return ad.findById(id);
	}

	public List<Accountings> findAll() {
		return ad.findAll();
	}

	public List<Accountings> findAllByTime(String time) {
		return ad.findAllByTime(time);
	}

	public List<Accountings> findAll(Integer curPage, Integer row) {
		return ad.findAll(curPage, row);
	}

	public int getCountsOfRow(Integer row) {
		return ad.getCountsOfRow(row);
	}

	public List<Autoclass> findAllByTimeAuto(String time) {
		return ad.findAllByTimeAuto(time);
	}

}
