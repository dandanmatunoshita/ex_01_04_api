package app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import app.dto.SensorDTO;
import app.dto.SensorInsertDTO;
import app.model.Sensor;
import app.repository.SensorRepository;

@Service
public class SensorService {

    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public SensorDTO salvar(SensorInsertDTO dto) {
        Sensor sensor = new Sensor(null, dto.unidade(), dto.valor(), dto.local());
        sensor = repository.save(sensor);
        return new SensorDTO(sensor);
    }

    public List<SensorDTO> listar() {
        return repository.findAll()
                .stream()
                .map(SensorDTO::new)
                .collect(Collectors.toList());
    }

    public SensorDTO buscarPorId(Long id) {
        Sensor sensor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado"));
        return new SensorDTO(sensor);
    }

    public SensorDTO atualizar(Long id, SensorInsertDTO dto) {
        Sensor sensor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado"));

        sensor.setUnidade(dto.unidade());
        sensor.setValor(dto.valor());
        sensor.setLocal(dto.local());

        sensor = repository.save(sensor);
        return new SensorDTO(sensor);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<SensorDTO> buscarPorLocal(String local) {
        return repository.findByLocal(local)
                .stream()
                .map(SensorDTO::new)
                .collect(Collectors.toList());
    }
}