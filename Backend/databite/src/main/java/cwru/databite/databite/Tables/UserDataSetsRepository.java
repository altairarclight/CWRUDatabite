package cwru.databite.databite.Tables;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataSetsRepository extends CrudRepository<UserDataSets, Integer> {

}
