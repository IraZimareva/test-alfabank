package zimareva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import zimareva.model.Box;
import zimareva.model.Item;
import zimareva.repository.BoxRepository;
import zimareva.repository.ItemRepository;
import zimareva.utils.TestObjectToXml;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@SpringBootApplication
public class TestAlfabankApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(TestAlfabankApplication.class, args);


        BoxRepository boxRepository =
                configurableApplicationContext.getBean(BoxRepository.class);
        ItemRepository itemRepository =
                configurableApplicationContext.getBean(ItemRepository.class);

        //TEST DATA
        //Первый (верхний) уровень иерархии
        Box personAlAl = new Box();
        boxRepository.save(personAlAl);
        Box personIvIv = new Box();
        boxRepository.save(personIvIv);
        Item personSiSi = new Item(null,"Red");
        itemRepository.save(personSiSi);

        //Второй уровень иерархии
        Box personArAr = new Box(personAlAl);
        boxRepository.save(personArAr);
        Box personYlYl = new Box(personIvIv);
        boxRepository.save(personYlYl);

        //Третий уровень иерархии
        Item personNaNa = new Item(personYlYl,"Наташкова Наталия");
        itemRepository.save(personNaNa);
        Item personKlKl = new Item(personYlYl, "Климов Клим");
        itemRepository.save(personKlKl);
        Box personKlaKla = new Box(personYlYl);
        boxRepository.save(personKlaKla);
        Item personKarKar = new Item( personYlYl, "black");
        itemRepository.save(personKarKar);


        System.out.println("\n \n Test xml parsing");
        try {
//            TestObjectToXml.marshal();
            TestObjectToXml.unmarshall();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
