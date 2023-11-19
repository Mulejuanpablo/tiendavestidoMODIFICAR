package com.chloe.chloeback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authresponse {
    private boolean success;
    private String message;
    // Otros campos según sea necesario
}
