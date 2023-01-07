package org.polytech.covid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    @JsonProperty
    private final String data;

    public Data(String data) {
        this.data = data;
    }
}
