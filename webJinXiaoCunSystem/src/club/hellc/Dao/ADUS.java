package club.hellc.Dao;

import java.util.List;

public interface ADUS {
	public int add(Object obj);

	public int delete(Object obj);

	public int update(Object obj);

	public Object findById(Integer id);

	public List<Object> findAll();
}
