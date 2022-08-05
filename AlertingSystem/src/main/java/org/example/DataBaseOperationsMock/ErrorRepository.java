package org.example.DataBaseOperationsMock;

import org.example.ErrorModels.ErrorEntity;

import java.sql.Time;
import java.time.Instant;
import java.util.List;

public class ErrorRepository {

    public ErrorEntity addAlert(ErrorEntity errorEntity){
        errorEntity.setTimeStamp(Instant.now().toEpochMilli());
        errorEntity.setClient("InsuranceService");
        AlertEntityTable.errorEntityList.add(errorEntity);
        return errorEntity;
    }

    public List<ErrorEntity> getAllErrorList(){
        return AlertEntityTable.errorEntityList;
    }
}
