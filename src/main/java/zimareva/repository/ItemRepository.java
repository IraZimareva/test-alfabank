package zimareva.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zimareva.model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query(nativeQuery = true)
    List<Long> findIdsByColorAndBoxId(@Param("idBox") Long idBox,
                                      @Param("color") String color);
}
