package zimareva.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zimareva.model.Item;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query(nativeQuery = true)
    Optional<List<BigInteger>> findItemsIdsByColorAndBoxId(@Param("idBox") Long idBox,
                                                           @Param("color") String color);
}
