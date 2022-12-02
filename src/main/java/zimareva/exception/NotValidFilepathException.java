package zimareva.exception;

import java.text.MessageFormat;

public class NotValidFilepathException extends RuntimeException{
    public NotValidFilepathException(String filepath) {
        super(MessageFormat.format("Not valid filepath. Can not read {0}", filepath));
    }
}
