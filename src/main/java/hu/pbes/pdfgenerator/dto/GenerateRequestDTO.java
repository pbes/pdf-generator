package hu.pbes.pdfgenerator.dto;

import lombok.Data;

import java.util.Map;

@Data
public class GenerateRequestDTO {
    private final String template;
    private final Map<String, Object> data;
}
