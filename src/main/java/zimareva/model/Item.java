package zimareva.model;

import zimareva.model.dto.ItemDTO;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    /*@SequenceGenerator(name = "item_seq", sequenceName = "item_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")*/
    private Long id;
    private String color;

    public Item() {
    }

    public Item(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Item from(ItemDTO itemDTO){
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setColor(itemDTO.getColor());
        return item;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
