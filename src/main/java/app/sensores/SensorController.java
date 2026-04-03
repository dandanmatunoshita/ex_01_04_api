package app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import app.dto.SensorDTO;
import app.dto.SensorInsertDTO;
import app.service.SensorService;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @PostMapping
    public SensorDTO cadastrar(@RequestBody SensorInsertDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<SensorDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public SensorDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public SensorDTO atualizar(@PathVariable Long id, @RequestBody SensorInsertDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/local/{local}")
    public List<SensorDTO> buscarPorLocal(@PathVariable String local) {
        return service.buscarPorLocal(local);
    }
}