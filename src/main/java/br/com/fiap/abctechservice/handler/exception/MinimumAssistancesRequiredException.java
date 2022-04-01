package br.com.fiap.abctechservice.handler.exception;

import lombok.Getter;

@Getter
public class MinimumAssistancesRequiredException extends RuntimeException {
    private final String description;

    public MinimumAssistancesRequiredException(String message, String description) {
        super(message);
        this.description = description;
    }

}