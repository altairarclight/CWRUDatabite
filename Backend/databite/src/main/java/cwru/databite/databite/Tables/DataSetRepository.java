package cwru.databite.databite.Tables;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DataSetRepository extends CrudRepository<DataSet, Integer> {

    @Query(value = "SELECT DISTINCT * FROM Datasets datasets WHERE datasets.datasetID = :datasetID", nativeQuery = true)
    @Transactional(readOnly = true)
    Collection<DataSet> findByDatasetID(@Param("datasetID") int datasetID);
}
