package cwru.databite.databite.Implementation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cwru.databite.databite.Interface.ICompany;
import cwru.databite.databite.Tables.CompanyRepository;
import cwru.databite.databite.Tables.Company;

@Controller
@RequestMapping(path = "company")
public class CompanyImpl implements ICompany {

	int companyID;
	String companyName;
	String domainName;

	private CompanyRepository companyRepo;

	private CompanyImpl(String companyName, int companyID) {
		this.companyName = companyName;
		this.companyID = companyID;
	}

	@PostMapping(path = "/registration")
	@Override
	public boolean companyRegistration(Company company) {
		if (companyRepo.save(company) != null) {
            //return true; If operation successful
            return true;
        }
        // else return false
        return false;
	}

	@DeleteMapping(path = "/delete")
	@Override
	public boolean companyDelete(Company company) {
		companyRepo.delete(company);

        // return true; If successful
        return true;
	}

	@PostMapping(path = "/modify")
	@Override
	public boolean companyModify(Company company) {
		if (companyRepo.save(company) != null) {
            // return true; If operation successful
            return true;
        }
        // else return false
        return false;
	} 

	@GetMapping(path = "/get")
    @Override
    public Company getCompany(String companyName) {
        return companyRepo.findByCompanyName(companyName).stream().findFirst().get();
    } 
}
