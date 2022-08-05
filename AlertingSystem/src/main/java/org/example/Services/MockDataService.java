package org.example.Services;

import org.example.DataBaseOperationsMock.AlertEntityTable;
import org.example.DataBaseOperationsMock.ErrorRepository;
import org.example.ErrorModels.ErrorEntity;

import java.util.ArrayList;

public class MockDataService {

    public void seedMockErrorEvents(){
        ErrorRepository errorRepository = new ErrorRepository();

        AlertEntityTable.errorEntityList =new ArrayList<>();


        ErrorEntity errorEntity1 = ErrorEntity.builder()
                .errorType("SLOW_API_TIME")
                .message("Slow API Reported in client")
                .build();

        ErrorEntity errorEntity2 = ErrorEntity.builder()
                .errorType("PAYMENT_EXCEPTION")
                .message("Upstream bank server rate limit")
                .build();

        ErrorEntity errorEntity3 = ErrorEntity.builder()
                .errorType("SLOW_API_TIME")
                .message("Upstream bank server not reachable")
                .build();

        ErrorEntity errorEntity4 = ErrorEntity.builder()
                .errorType("SLOW_API_TIME")
                .message("Slow DB Response in client")
                .build();

        ErrorEntity errorEntity5 = ErrorEntity.builder()
                .errorType("PAYMENT_EXCEPTION")
                .message("Slow DB Response in client")
                .build();


        errorRepository.addAlert(errorEntity1);
        errorRepository.addAlert(errorEntity2);
        errorRepository.addAlert(errorEntity3);
        errorRepository.addAlert(errorEntity4);
        errorRepository.addAlert(errorEntity5);

    }
}
