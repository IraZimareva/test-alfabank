package zimareva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimareva.model.Box;

@Repository
public interface BoxRepository extends CrudRepository<Box, Long> {
}
