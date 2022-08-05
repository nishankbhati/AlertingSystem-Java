package org.example;

import org.example.AlertConfigImpl.AlertConfiguration;
import org.example.AlertConfigImpl.AlertConfigurationFactory;
import org.example.AlertModels.AlertEntity;
import org.example.Services.AlertService;
import org.example.Services.MockDataService;

public class Main {
    public static void main(String[] args) {

        AlertEntity alertEntity = mockErrorsAndRegisterMockAlert();

        processRegisteredAlert(alertEntity);
    }

    private static void processRegisteredAlert(AlertEntity alertEntity) {
        AlertConfigurationFactory alertConfigurationFactory = new AlertConfigurationFactory();
        AlertConfiguration alertConfiguration = alertConfigurationFactory.getAlertConfigImpl(alertEntity);
        System.out.println("Alert Processing Impl Fetched");

        alertConfiguration.processErrorCheck(alertEntity);
        System.out.println("Alert Processed");
    }

    private static AlertEntity mockErrorsAndRegisterMockAlert() {
        MockDataService mockDataService = new MockDataService();
        mockDataService.seedMockErrorEvents();
        System.out.println("Mock Data Filled");

        AlertService alertService = new AlertService();
        AlertEntity alertEntity = alertService.createAlert();
        System.out.println("Alert Entity Created");
        return alertEntity;
    }

}