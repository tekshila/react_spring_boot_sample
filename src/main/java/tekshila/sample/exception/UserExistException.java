package tekshila.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }

}
