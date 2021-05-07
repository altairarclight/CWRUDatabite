package cwru.databite.databite.Tables;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT DISTINCT user FROM User user WHERE user.username LIKE :username%")
    @Transactional(readOnly = true)
    Collection<User> findByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM User user WHERE user.companyID = :companyID", nativeQuery = true)
    @Transactional(readOnly = false)
    Collection<User> findCompanyUsers(@Param("companyID") int companyID);
}
