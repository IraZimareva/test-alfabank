package zimareva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import zimareva.model.Box;
import zimareva.model.Item;
import zimareva.repository.BoxRepository;
import zimareva.repository.ItemRepository;
import zimareva.service.MainService;
import zimareva.utils.TestObjectToXml;
import zimareva.utils.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Arrays;

@SpringBootApplication
public class TestAlfabankApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(TestAlfabankApplication.class, args);

        BoxRepository boxRepository =
                configurableApplicationContext.getBean(BoxRepository.class);
        ItemRepository itemRepository =
                configurableApplicationContext.getBean(ItemRepository.class);
/*

        //TEST DATA
        //Третий уровень иерархии
        Item personNaNa = new Item("blue");
        Item personKlKl = new Item("red");
        Box personKlaKla = new Box(null, null);
        Item personKarKar = new Item("black");

        //Второй уровень иерархии
        Box personArAr = new Box(Arrays.asList(personKlaKla), null);
        Box personYlYl = new Box(null, Arrays.asList(personNaNa, personKlKl, personKarKar));

        //Первый (верхний) уровень иерархии
        Box personAlAl = new Box(Arrays.asList(personArAr, personYlYl), null);
        boxRepository.save(personAlAl);
        Box personIvIv = new Box(null, null);
        boxRepository.save(personIvIv);
        Item personSiSi = new Item("red");
        itemRepository.save(personSiSi);
*/


        MainService mainService =
                configurableApplicationContext.getBean(MainService.class);

        System.out.println("\n \n Test xml parsing");
        try {
//            TestObjectToXml.marshal();
//            TestObjectToXml.unmarshall();
            mainService.fillDB(XMLParser.unmarshall());
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
