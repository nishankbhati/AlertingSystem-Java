package org.example.AlertConfigImpl;

import org.example.AlertModels.AlertConfig;
import org.example.AlertModels.AlertEntity;
import org.example.DataBaseOperationsMock.ErrorRepository;
import org.example.ErrorModels.ErrorEntity;

import java.util.List;

public class SimpleCountAlertConfiguration implements AlertConfiguration {

    @Override
    public void processErrorCheck(AlertEntity alertEntity) {

        String eventType = alertEntity.getEventType();
        Integer thresholdCount = alertEntity.getAlertConfig().getCount();

        ErrorRepository errorRepository = new ErrorRepository();

        List<ErrorEntity> errorEntityList = errorRepository.getAllErrorList();

        Integer errorCount = 0;

        for (ErrorEntity errorEntity : errorEntityList) {
            if (errorEntity.getErrorType().equalsIgnoreCase(eventType)) {
                errorCount++;
            }
            if (errorCount == thresholdCount) {
                processErrorAction(alertEntity);
                return;
            }
        }
    }


    // Separate Factory for each dispatch StrategyImpl, but time constraint
    private void processErrorAction(AlertEntity alertEntity) {
        if (alertEntity.getDispatchStrategy().getType().equals("CONSOLE")) {
            System.out.println(alertEntity.getDispatchStrategy().getMessage());
        }
    }
}
