package cwru.databite.databite.Implementation;

import cwru.databite.databite.Interface.ICompany;

public class Company implements ICompany {

	private int companyID;
	private String companyName;
	private String domainName;

	private Company(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public void companyRegistration(String companyName) {

	}

	@Override
	public void companyDelete(String companyName, int companyID) {

	}

	@Override
	public void companyModify(String companyName, int companyID) {

	}

	@Override
	public void getCompany(int companyID) {

	}

	public int getCompanyID() {
		return this.companyID;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public String getDomainName() {
		return this.domainName;
	}
}
