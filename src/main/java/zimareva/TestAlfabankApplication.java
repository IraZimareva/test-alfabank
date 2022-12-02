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
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class TestAlfabankApplication {
    private static Logger logger = Logger.getLogger(TestAlfabankApplication.class.getName());

    public static void main(String[] args) {
        //mvn spring-boot:run -Dspring-boot.run.arguments="src\\main\\resources\\input.xml"
        //mvn spring-boot:run -Dspring-boot.run.arguments="file:src\\main\\resources\\input.xml"
        //mvn spring-boot:run -Dspring-boot.run.arguments="url:file:///D:/ira/IdeaProject/test-alfabank/src/main/resources/input.xml"
        //mvn spring-boot:run -Dspring-boot.run.arguments="classpath:input.xml"

        //http://localhost:8080/h2/ - консоль СУБД Н2


        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(TestAlfabankApplication.class, args);

        /*
        BoxRepository boxRepository =
                configurableApplicationContext.getBean(BoxRepository.class);
        ItemRepository itemRepository =
                configurableApplicationContext.getBean(ItemRepository.class);

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

        logger.info("Test XML parsing start");
        try {
//            TestObjectToXml.marshal();
//            TestObjectToXml.unmarshall();
//            mainService.fillDB(TestObjectToXml.unmarshall());
//            mainService.fillDB(XMLParser.unmarshall(args[0]));
            mainService.parseFilepath(args[0]);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Тест нативного sql запроса
        /*ItemRepository itemRepository =
                configurableApplicationContext.getBean(ItemRepository.class);
        List<Long> result = itemRepository.findItemsIdsByColorAndBoxId(1L, "red");
        System.out.println("Result of native query " + result);*/
    }
}
