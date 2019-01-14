package club.hellc.Biz;

import java.util.List;

import club.hellc.Dao.ProductDaoImpl;
import club.hellc.pojo.Product;

public class ProductBiz {
	ProductDaoImpl proDao = new ProductDaoImpl();

	public int add(Product pro) {
		return proDao.add(pro);
	}

	public int deleteById(Integer id) {
		return proDao.deleteById(id);
	}

	public int updateById(Product pro) {
		return proDao.updateById(pro);
	}

	public Product findById(Integer id) {
		return proDao.findById(id);
	}

	public List<Product> findAll() {
		return proDao.findAll();
	}

	public List<Product> findAllByName(String proname) {
		return proDao.findAllByName(proname);
	}
}
