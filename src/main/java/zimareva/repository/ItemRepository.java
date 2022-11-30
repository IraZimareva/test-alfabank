package zimareva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimareva.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
