package cwru.databite.databite.Interface;

public interface ITable {

	public boolean insert(Object insertObject);

	public boolean delete(Object deleteObject);

	public boolean modify(String name, String password, String companyId);
}
