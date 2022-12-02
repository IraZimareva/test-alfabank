package zimareva.exception;

import java.text.MessageFormat;

public class IdsNotFoundException extends RuntimeException {
    public IdsNotFoundException(Long id, String color) {
        super(MessageFormat.format("Could not found ids of items for id = {0} and color = {1}", id, color));
    }
}
