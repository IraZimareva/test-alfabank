package zimareva.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import zimareva.model.dto.BoxDTO;
import zimareva.model.dto.ItemDTO;
import zimareva.model.dto.StorageDTO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

//todo: сделать нормальные тесты вместо этого класса
public class TestObjectToXml {
    public static StorageDTO getTestData() {
        //TEST DATA
        //Третий уровень иерархии
        ItemDTO personNaNa = new ItemDTO(1L, "blue");
        ItemDTO personKlKl = new ItemDTO(2L, "red");
        BoxDTO personKlaKla = new BoxDTO(1L, null, null);
        ItemDTO personKarKar = new ItemDTO(3L, "black");

        //Второй уровень иерархии
        BoxDTO personArAr = new BoxDTO(4L, Arrays.asList(personKlaKla), null);
        BoxDTO personYlYl = new BoxDTO(5L, null, Arrays.asList(personNaNa, personKlKl, personKarKar));

        //Первый (верхний) уровень иерархии
        BoxDTO personAlAl = new BoxDTO(6L, Arrays.asList(personArAr, personYlYl), null);
        BoxDTO personIvIv = new BoxDTO(7L, null, null);
        ItemDTO personSiSi = new ItemDTO(4L, "red");

        //Нулевой уровень иерархии
        List<BoxDTO> boxDTOList = Arrays.asList(personAlAl, personIvIv);
        List<ItemDTO> itemDTOList = Arrays.asList(personSiSi);
        return new StorageDTO(boxDTOList, itemDTOList);
    }

    public static void marshal() throws JAXBException {
        //Сама реализация парсинга
        JAXBContext jaxbContext = JAXBContext.newInstance(StorageDTO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(getTestData(), new File("./output.xml"));
        marshaller.marshal(getTestData(), System.out);
    }

    public static StorageDTO unmarshall() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(StorageDTO.class);
        Unmarshaller mar = context.createUnmarshaller();
        StorageDTO storageDTO = (StorageDTO) mar.unmarshal(new FileReader("src\\main\\resources\\input.xml"));
        System.out.println("Unmarshalling object   " + storageDTO.toString());

        getJSONListResult(storageDTO);

        /*City from = cityService.addCity(unmDistance.getFromCity());
        City to = cityService.addCity(unmDistance.getToCity());*/
        return storageDTO;
    }

    private static String getJSONListResult (StorageDTO storageDTO){
        ObjectMapper mapper = new ObjectMapper();
        String regRespStr = null;
        try{
            regRespStr = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(storageDTO);
            System.out.println("Formatted JSON Response:" + regRespStr);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        return regRespStr;
    }
}
