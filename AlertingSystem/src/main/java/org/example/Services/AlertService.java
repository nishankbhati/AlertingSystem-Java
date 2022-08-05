package org.example.Services;

import org.example.AlertModels.AlertConfig;
import org.example.AlertModels.AlertEntity;
import org.example.AlertModels.DispatchStrategy;


/**
 * CRUDS for creating, updating and deleting alerts
 * */
public class AlertService {

    public AlertEntity createAlert(){
        AlertConfig alertConfig = AlertConfig.builder()
                .type("SIMPLE_COUNT")
                .count(2)
                .build();
        DispatchStrategy dispatchStrategy = DispatchStrategy.builder()
                .type("CONSOLE")
                .message("High Latency in Insurance Cluster Reported")
                .build();
        AlertEntity alertEntity = AlertEntity.builder()
                .client("InsuranceService")
                .eventType("SLOW_API_TIME")
                .alertConfig(alertConfig)
                .dispatchStrategy(dispatchStrategy)
                .build();
        return alertEntity;
    }
}
