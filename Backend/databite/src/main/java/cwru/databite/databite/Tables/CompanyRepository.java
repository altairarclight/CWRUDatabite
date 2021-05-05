package cwru.databite.databite.Tables;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    @Query("SELECT DISTINCT user FROM Company company WHERE company.companyName LIKE :companyName%")
    @Transactional(readOnly = true)
    Collection<Company> findByCompanyName(@Param("companyName") String companyName);
}