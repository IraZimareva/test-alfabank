package zimareva.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import zimareva.model.dto.StorageDTO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class XMLParser {
    private static Logger logger = Logger.getLogger(XMLParser.class.getName());

    public static StorageDTO unmarshallFile(String filepath) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(StorageDTO.class);
        Unmarshaller mar = context.createUnmarshaller();
        return (StorageDTO) mar.unmarshal(new FileReader(filepath));
    }

    public static StorageDTO unmarshallUrl(String filepath) throws JAXBException, MalformedURLException {
        JAXBContext context = JAXBContext.newInstance(StorageDTO.class);
        Unmarshaller mar = context.createUnmarshaller();
        return (StorageDTO) mar.unmarshal(new URL(filepath));
    }

    public static StorageDTO unmarshallClasspath(String filepath) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(StorageDTO.class);
        Unmarshaller mar = context.createUnmarshaller();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        Resource resource = applicationContext.getResource(filepath);

        logger.info("Resource.getFile() " + resource.getFile());
        logger.info("Resource " + resource);

        return (StorageDTO) mar.unmarshal(resource.getFile());
    }
}
