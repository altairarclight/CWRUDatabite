package cwru.databite.databite.Implementation;

import cwru.databite.databite.Interface.ITable;

public class Table implements ITable {

	@Override
	public boolean insert(Object insertObject) {
		// return whether query is successful
		return false;
	}

	@Override
	public boolean delete(Object deleteObject) {
		// return whether delete is successful
		return false;
	}

	@Override
	public boolean modify(String name, String password, String companyId) {
		// return whether object modified
		return false;
	}

	public void get(String name) {

	}
}
