package zimareva.model.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Storage")
@XmlType(propOrder = {"boxList", "items"})
public class StorageDTO {
    private List<BoxDTO> boxList = new ArrayList<>();
    private List<ItemDTO> items = new ArrayList<>();

    public StorageDTO() {
    }

    public StorageDTO(List<BoxDTO> boxList, List<ItemDTO> items) {
        this.boxList = boxList;
        this.items = items;
    }

    public List<BoxDTO> getBoxList() {
        return boxList;
    }

    @XmlElement(name = "Box")
    public void setBoxList(List<BoxDTO> boxList) {
        this.boxList = boxList;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    @XmlElement(name = "Item")
    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "StorageDTO{" +
                "boxList=" + boxList +
                ", items=" + items +
                '}';
    }
}
