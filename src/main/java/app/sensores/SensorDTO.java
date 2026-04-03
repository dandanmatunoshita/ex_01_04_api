package app.dto;

import app.model.Sensor;

public record SensorDTO(
    Long id,
    String unidade,
    Float valor,
    String local
) {
    public SensorDTO(Sensor sensor) {
        this(
            sensor.getId(),
            sensor.getUnidade(),
            sensor.getValor(),
            sensor.getLocal()
        );
    }
}