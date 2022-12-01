package zimareva.model.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Item")
@XmlType(propOrder = { "id", "color" })
public class ItemDTO {
    private Long id;
    private String color;

    public ItemDTO() {
    }

    public ItemDTO(Long id, String color) {
        this.id = id;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    @XmlAttribute
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
