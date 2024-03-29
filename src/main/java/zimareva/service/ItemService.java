package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.exception.IdsNotFoundException;
import zimareva.model.Item;
import zimareva.model.transferJSON.RequestJSON;
import zimareva.repository.ItemRepository;

import java.math.BigInteger;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    public List<BigInteger> getIdsByJSON(RequestJSON requestJSON){
        return itemRepository.findItemsIdsByColorAndBoxId(requestJSON.getBoxId(), requestJSON.getColor()).orElseThrow(() ->
                new IdsNotFoundException(requestJSON.getBoxId(), requestJSON.getColor()));
    }
}
