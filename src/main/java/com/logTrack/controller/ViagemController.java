package com.logTrack.controller;

import com.logTrack.entity.Viagem;
import com.logTrack.repository.ViagemRepository;
import com.logTrack.service.RelatorioService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

    private final ViagemRepository repository;
    private final RelatorioService relatorioService;

    public ViagemController(ViagemRepository repository, RelatorioService relatorioService) {
        this.repository = repository;
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public List<Viagem> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Viagem salvar(@RequestBody Viagem viagem) {
        return repository.save(viagem);
    }

    @GetMapping("/relatorios")
    public Map<String, Object> relatorios(@RequestParam(required = false) Long veiculoId) {
        return relatorioService.getDashboard(veiculoId);
    }
}
