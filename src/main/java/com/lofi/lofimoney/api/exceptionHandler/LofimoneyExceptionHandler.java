package com.lofi.lofimoney.api.exceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class LofimoneyExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
                                                               HttpHeaders httpHeaders,
                                                               HttpStatus httpStatus, WebRequest request) {
        String userMessage = messageSource.getMessage("invalid.message", null, LocaleContextHolder.getLocale());
        String developerMessage = exception.getCause().toString();
        List<Error> errors = Arrays.asList(new Error(userMessage, developerMessage));
        return handleExceptionInternal(exception, errors, httpHeaders, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders httpHeaders,
                                                                  HttpStatus httpStatus, WebRequest request) {
        List<Error> errors = createErrorsList(exception.getBindingResult());
        return handleExceptionInternal(exception, errors, httpHeaders, HttpStatus.BAD_REQUEST, request);
    }

    private List<Error> createErrorsList(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<>();


        for (FieldError fieldError: bindingResult.getFieldErrors()) {
            String userMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            String developerMessage = fieldError.toString();
            errors.add(new Error(userMessage, developerMessage));
        }

        return errors;
    }

    public static class Error {

        private String userMessage;
        private String developerMessage;

        public Error(String userMessage, String developerMessage) {
            this.userMessage = userMessage;
            this.developerMessage = developerMessage;
        }

        public String getUserMessage() {
            return userMessage;
        }

        public void setUserMessage(String userMessage) {
            this.userMessage = userMessage;
        }

        public String getDeveloperMessage() {
            return developerMessage;
        }

        public void setDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
        }
    }
}
