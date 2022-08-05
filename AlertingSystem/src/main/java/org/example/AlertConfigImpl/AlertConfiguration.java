package org.example.AlertConfigImpl;

import org.example.AlertModels.AlertConfig;
import org.example.AlertModels.AlertEntity;

public interface AlertConfiguration {
    void processErrorCheck(AlertEntity alertEntity);
}
