package com.test.tasktwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class TransformedColorDTO {
    public Integer parent;
    public String name;
    public String color;
    public List<TransformedColorDTO> subClasses = new ArrayList<>();
    public TransformedColorDTO(String name, String color) {
        this.name = name;
        this.color = color;
    }
}