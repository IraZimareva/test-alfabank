package zimareva.model;

import zimareva.model.dto.BoxDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "box")
public class Box {
    @Id
    /*@SequenceGenerator(name = "box_seq", sequenceName = "box_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "box_seq")*/
    private Long id;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "contained_in")
    private List<Box> boxList = new ArrayList<>();

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "contained_in")
    private List<Item> items = new ArrayList<>();

    public Box() {
    }

    public Box(Long id, List<Box> boxList, List<Item> items) {
        this.id = id;
        this.boxList = boxList;
        this.items = items;
    }

    public Box(List<Box> boxList, List<Item> items) {
        this.boxList = boxList;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<Box> boxList) {
        this.boxList = boxList;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static Box from(BoxDTO boxDTO){
        Box box = new Box();
        box.setId(boxDTO.getId());
        box.setBoxList(boxDTO.getBoxList().stream().map(Box::from).collect(Collectors.toList()));
        box.setItems(boxDTO.getItems().stream().map(Item::from).collect(Collectors.toList()));
        return box;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", boxList=" + boxList +
                ", items=" + items +
                '}';
    }
}
