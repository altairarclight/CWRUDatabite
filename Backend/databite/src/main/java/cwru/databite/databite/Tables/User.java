package cwru.databite.databite.Tables;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    // 0 = regular user
    // 1 = company admin
    // 2 = system admin
    @Column(name = "account_type")
    private int accountType;

    @OneToMany(mappedBy = "user")
    private Set<UserDataSets> userDatasets;

    @ManyToOne
    @JoinColumn(name = "companyID", nullable = true)
    private Company company;

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

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

    public Set<UserDataSets> getUserDatasets() {
        return this.userDatasets;
    }

    public void setUserDatasets(Set<UserDataSets> userDatasets) {
        this.userDatasets = userDatasets;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

}