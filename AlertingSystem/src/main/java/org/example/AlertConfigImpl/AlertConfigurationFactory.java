package org.example.AlertConfigImpl;

import org.example.AlertModels.AlertEntity;

public class AlertConfigurationFactory {

    public AlertConfiguration getAlertConfigImpl(AlertEntity alertEntity){
        String alertType = alertEntity.getAlertConfig().getType();
        if(alertType.equalsIgnoreCase("SIMPLE_COUNT")){
            return new SimpleCountAlertConfiguration();
        } else if(alertType.equalsIgnoreCase("BUCKETED_WINDOW")){
            return new BucketedWindowAlertConfiguration();
        } else if(alertType.equalsIgnoreCase("MOVING_WINDOW")){
            return new MovingWindowAlertConfiguration();
        }
        return null; // prone to NPE, will be dealt based on time
    }
}
