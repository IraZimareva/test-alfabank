package zimareva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @SequenceGenerator(name = "item_seq", sequenceName = "item_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    private Long id;

    //todo: думаю, что от этого можно отказаться вполне
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contained_in")
    @JsonIgnoreProperties("items")
    private Box box;
    private String color;

    public Item() {
    }

    public Item(Box box, String color) {
        this.box = box;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", box=" + box +
                ", color='" + color + '\'' +
                '}';
    }
}
