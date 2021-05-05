package cwru.databite.databite.Tables;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "company")
public class Company {

    @Column(name = "companyName")
    private String companyName;

    @Id
    @Column(name = "companyID")
    private int companyID;

    // @ManyToMany
    // @JoinTable(name = "companydatasets", joinColumns = @JoinColumn(name =
    // "companyID"), inverseJoinColumns = @JoinColumn(name = "datasetID"))
    // private Set<DataSet> companyDatasets;

    @OneToMany(mappedBy = "company")
    Set<User> companyUsers;

    public Set<User> getCompanyUsers() {
        return this.companyUsers;
    }

    public void setCompanyUsers(Set<User> companyUsers) {
        this.companyUsers = companyUsers;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    // public Set<DataSet> getCompanyDatasets() {
    // return this.companyDatasets;
    // }

    // public void setCompanyDatasets(Set<DataSet> companyDatasets) {
    // this.companyDatasets = companyDatasets;
    // }

}