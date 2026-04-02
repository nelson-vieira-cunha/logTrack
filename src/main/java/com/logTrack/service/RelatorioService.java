package com.logTrack.service;

import com.logTrack.repository.ManutencaoRepository;
import com.logTrack.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RelatorioService {


        @Autowired
        private ManutencaoRepository manutencaoRepository;

        @Autowired
        private ViagemRepository viagemRepository;

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
