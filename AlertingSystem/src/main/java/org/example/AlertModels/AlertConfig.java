package org.example.AlertModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertConfig {
    private String type;
    private Integer count;
    private Integer windowSize; // For simplicity taking it in hours as strategy BUCKETED_WINDOW is in 1 hour size
}
