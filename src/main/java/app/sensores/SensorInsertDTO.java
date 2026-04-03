package app.dto;

public record SensorInsertDTO(
    String unidade,
    Float valor,
    String local
) {}