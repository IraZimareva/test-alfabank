package zimareva.utils;

import zimareva.model.dto.StorageDTO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XMLParser {
    public static StorageDTO unmarshall() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(StorageDTO.class);
        Unmarshaller mar = context.createUnmarshaller();
        StorageDTO storageDTO = (StorageDTO) mar.unmarshal(new FileReader("src\\main\\resources\\input.xml"));
        return storageDTO;
    }
}
