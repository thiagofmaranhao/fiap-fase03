package br.com.fiap.abctechservice.handler.exception;

import lombok.Getter;

@Getter
public class MaximumAssistancesException extends RuntimeException {
    private final String description;

    public MaximumAssistancesException(String message, String description) {
        super(message);
        this.description = description;
    }
}
