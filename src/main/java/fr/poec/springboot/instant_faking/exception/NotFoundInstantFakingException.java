package fr.poec.springboot.instant_faking.exception;

import lombok.Getter;

@Getter
public class NotFoundInstantFakingException extends RuntimeException {

    private String type;

    private String field;

    private Object value;

    public NotFoundInstantFakingException(String type, String field, Object value) {
        super("Entity not found");
        this.type = type;
        this.field = field;
        this.value = value;
    }
}
