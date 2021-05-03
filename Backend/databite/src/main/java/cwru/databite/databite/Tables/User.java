package cwru.databite.databite.Tables;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user")
public class User {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "companyID")
    private int companyID;

    @ManyToMany
    @JoinTable(name = "userdatasets", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "datasetID"))
    private Set<DataSet> userDatasets;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public Set<DataSet> getUserDatasets() {
        return this.userDatasets;
    }

    public void setUserDatasets(Set<DataSet> userDatasets) {
        this.userDatasets = userDatasets;
    }

}