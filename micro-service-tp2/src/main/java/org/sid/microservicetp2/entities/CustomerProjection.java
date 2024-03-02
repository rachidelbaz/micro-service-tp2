package org.sid.microservicetp2.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCutomer",types = Customer.class)
public interface CustomerProjection {
    public Long getId();
    public String getName();
}
