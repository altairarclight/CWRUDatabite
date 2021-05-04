package cwru.databite.databite.Tables;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "datasets")
public class DataSet {

    @Column(name = "username")
    private String username;

    @Column(name = "companyID")
    private int companyID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "datasetID")
    private int datasetID;

    @ManyToMany
    @JoinTable(name = "userdatasets", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "datasetID"))
    private Set<User> users;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getDatasetID() {
        return this.datasetID;
    }

    public void setDatasetID(int datasetID) {
        this.datasetID = datasetID;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
