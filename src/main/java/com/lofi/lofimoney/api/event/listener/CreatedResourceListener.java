package com.lofi.lofimoney.api.event.listener;

import com.lofi.lofimoney.api.event.CreatedResourceEvent;
import com.lofi.lofimoney.api.model.Person;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

public class CreatedResourceListener implements ApplicationListener<CreatedResourceEvent> {

    @Override
    public void onApplicationEvent(CreatedResourceEvent createdResourceEvent) {
        HttpServletResponse response = createdResourceEvent.getResponse();
        Long code = createdResourceEvent.getCode();

        addHeaderLocation(response, code);
    }

    private void addHeaderLocation(HttpServletResponse response, Long code) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("{/id}").buildAndExpand(code).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
