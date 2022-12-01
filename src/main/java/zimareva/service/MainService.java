package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.model.Box;
import zimareva.model.Item;
import zimareva.model.dto.BoxDTO;
import zimareva.model.dto.ItemDTO;
import zimareva.model.dto.StorageDTO;

@Service
public class MainService {

    private final BoxService boxService;
    private final ItemService itemService;

    @Autowired
    public MainService(BoxService boxService, ItemService itemService) {
        this.boxService = boxService;
        this.itemService = itemService;
    }

    //TODO: скорее всего эта логика будет вынесена в утилитный класс XMLParser
    public void fillDB(StorageDTO storageDTO) {
        for (BoxDTO boxDTO : storageDTO.getBoxList()) {
            Box box = Box.from(boxDTO);
            boxService.addBox(box);
        }
        for (ItemDTO itemDTO: storageDTO.getItems()){
            Item item = Item.from(itemDTO);
            itemService.addItem(item);
        }
    }
}
