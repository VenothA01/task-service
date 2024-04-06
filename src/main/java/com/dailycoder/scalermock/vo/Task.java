package com.dailycoder.scalermock.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Generated;

@Data
public class Task {

    @Generated
    private int id;

    @NotBlank
    private String title;

    @NotEmpty
    private String description;

    private boolean completed;
}
