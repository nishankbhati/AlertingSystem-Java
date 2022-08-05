package org.example.AlertModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertEntity {
    private String client;
    private String eventType;
    private AlertConfig alertConfig;
    private DispatchStrategy dispatchStrategy;
}
