package zimareva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "box")
public class Box {
    @Id
    @SequenceGenerator(name = "box_seq", sequenceName = "box_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "box_seq")
    private Long id;

    //todo: может оставить только OneToMany?
    //todo: может отказаться от параметризации. Или лучше создать общий интерфейс (или абстрактный класс), чтобы не было миллион листов
    @OneToMany(
            mappedBy = "box"
    )
    @JsonIgnoreProperties("box")
    private List<Box> boxList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contained_in")
    @JsonIgnoreProperties("boxList")
    private Box box;

    @OneToMany(
            mappedBy = "box"
    )
    @JsonIgnoreProperties("box")
    private List<Item> items = new ArrayList<>();

    public Box() {
    }

    public Box(Box box) {
        this.box = box;
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

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", boxList=" + boxList +
                ", box=" + box +
                ", items=" + items +
                '}';
    }
}
