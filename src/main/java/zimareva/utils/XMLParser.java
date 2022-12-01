package zimareva.utils;

import zimareva.model.dto.StorageDTO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XMLParser {
    public static StorageDTO unmarshall(String filepath) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(StorageDTO.class);
        Unmarshaller mar = context.createUnmarshaller();
        StorageDTO storageDTO = (StorageDTO) mar.unmarshal(new FileReader(filepath));
        return storageDTO;
    }

    //todo: остановилась здесь на выборе источника данных. Что-то непонятно
    public static String parseFilepath(String filepath){
        String[] splitFilepath = filepath.split(":");

        for (String word : splitFilepath) {
            System.out.println(word);
        }

        switch (splitFilepath[0]){
            case "file":
                System.out.println("one");
                break;

            case "classpath":
                System.out.println("two");
                break;

            case "url":

                System.out.println("three");
                break;

            default:
                System.out.println("no match");
                break;
        }

        return
    }
}
