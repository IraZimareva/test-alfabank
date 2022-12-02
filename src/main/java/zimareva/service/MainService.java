package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.exception.NotValidFilepathException;
import zimareva.model.Box;
import zimareva.model.Item;
import zimareva.model.dto.BoxDTO;
import zimareva.model.dto.ItemDTO;
import zimareva.model.dto.StorageDTO;
import zimareva.utils.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.logging.Logger;

@Service
public class MainService {

    private static Logger logger = Logger.getLogger(MainService.class.getName());

    private final BoxService boxService;
    private final ItemService itemService;

    @Autowired
    public MainService(BoxService boxService, ItemService itemService) {
        this.boxService = boxService;
        this.itemService = itemService;
    }

    public void parseFilepath(String filepath) throws JAXBException, IOException {
        String[] splitFilepath = filepath.split(":", 2);

        for (int i = 0; i < splitFilepath.length; i++) {
            logger.info("Spliter string " + i + " " + splitFilepath[i]);
        }

        switch (splitFilepath[0]){
            case "file":
                logger.info("type file: ");
                fillDB(XMLParser.unmarshallFile(splitFilepath[1]));
                break;

            case "classpath":
                logger.info("type classpath: ");
                fillDB(XMLParser.unmarshallClasspath(filepath));
                break;

            case "url":
                logger.info("type url: ");
                fillDB(XMLParser.unmarshallUrl(splitFilepath[1]));
                break;

            default:
                logger.info("no match");
                throw new NotValidFilepathException(filepath);
        }
    }

    private void fillDB(StorageDTO storageDTO) {
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
