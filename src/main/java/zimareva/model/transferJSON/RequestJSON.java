package zimareva.model.transferJSON;

public class RequestJSON {
    private Long boxId;
    private String color;

    public RequestJSON() {
    }

    public Long getId() {
        return boxId;
    }

    public void setId(Long id) {
        this.boxId = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
