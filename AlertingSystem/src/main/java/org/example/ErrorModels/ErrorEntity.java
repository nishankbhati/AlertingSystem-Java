package org.example.ErrorModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorEntity {
    private String errorType;
    private String client; // Simplicity Assuming Single Client instead of multi tenant system
    private String message;
    private Long timeStamp;
}
