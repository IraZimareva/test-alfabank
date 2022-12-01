package zimareva.model.transferJSON;

public class RequestJSON {
    private Long boxId;
    private String color;

    public RequestJSON() {
    }

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
