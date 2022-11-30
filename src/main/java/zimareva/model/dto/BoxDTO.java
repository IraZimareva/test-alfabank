package zimareva.model.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Box")
@XmlType(propOrder = {"id", "items", "boxList"})
public class BoxDTO {
    private Long id;
    private List<BoxDTO> boxList = new ArrayList<>();
    private List<ItemDTO> items = new ArrayList<>();

    public BoxDTO() {
    }

    public BoxDTO(Long id, List<BoxDTO> boxList, List<ItemDTO> items) {
        this.id = id;
        this.boxList = boxList;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
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
        return "BoxDTO{" +
                "id=" + id +
                ", boxList=" + boxList +
                ", items=" + items +
                '}';
    }
}
