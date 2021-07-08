package com.lofi.lofimoney.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class CreatedResourceEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private HttpServletResponse response;
    private Long code;

    public CreatedResourceEvent(Object source, HttpServletResponse response, Long code) {
        super(source);
        this.response = response;
        this.code = code;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCode() {
        return code;
    }

}
