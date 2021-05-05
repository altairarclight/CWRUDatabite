package cwru.databite.databite.Interface;

import cwru.databite.databite.Tables.Company;

public interface ICompany {

	public boolean companyRegistration(Company company);

	public boolean companyDelete(Company company);

	public boolean companyModify(Company company);

	public Company getCompany(String companyName);
}
