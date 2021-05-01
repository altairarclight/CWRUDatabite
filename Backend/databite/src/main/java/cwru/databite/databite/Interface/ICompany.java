package cwru.databite.databite.Interface;

public interface ICompany {

	public void companyRegistration(String companyName);

	public void companyDelete(String companyName, int companyID);

	public void companyModify(String companyName, int companyID);

	public void getCompany(int companyID);
}
