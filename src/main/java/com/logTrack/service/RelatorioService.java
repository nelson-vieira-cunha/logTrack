package com.logTrack.service;

import com.logTrack.repository.ViagemRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RelatorioService {

    private final ViagemRepository viagemRepository;

    public RelatorioService(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    public Map<String, Object> getDashboard(Long veiculoId) {
        Map<String, Object> map = new HashMap<>();

        map.put("totalKmFrota", viagemRepository.totalKmFrota());
        map.put("mediaKm", viagemRepository.mediaKm());
        map.put("totalViagens", viagemRepository.totalViagens());
        map.put("volumePorCategoria", viagemRepository.volumePorCategoria());

        if (veiculoId != null) {
            map.put("totalKmVeiculo", viagemRepository.totalKmPorVeiculo(veiculoId));
        }

        return map;
    }
}