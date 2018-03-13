package repository;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author mali.sahin
 * @date 13-Mar-18
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor {
}
