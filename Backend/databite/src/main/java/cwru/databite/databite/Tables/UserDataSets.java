package cwru.databite.databite.Tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdatasets")
public class UserDataSets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userDataSetID")
    private int datasetID;

    @Column(name = "username")
    private User user;

    @Column(name = "datasetID")
    private DataSet dataSet;

    @Column(name = "can_edit")
    private boolean canEdit;

    public int getDatasetID() {
        return this.datasetID;
    }

    public void setDatasetID(int datasetID) {
        this.datasetID = datasetID;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DataSet getDataSet() {
        return this.dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public boolean isCanEdit() {
        return this.canEdit;
    }

    public boolean getCanEdit() {
        return this.canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

}
