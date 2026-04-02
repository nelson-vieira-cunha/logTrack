package com.logTrack.service;

import com.logTrack.repository.ManutencaoRepository;
import com.logTrack.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @Autowired
    private ViagemRepository viagemRepository;

    public Map<String, Object> getDashboard() {
        Map<String, Object> map = new HashMap<>();

        map.put("proximasManutencoes", manutencaoRepository.proximasManutencoes());
        map.put("rankingUtilizacao", viagemRepository.rankingUtilizacao());
        map.put("projecaoFinanceira", manutencaoRepository.projecaoFinanceira());

        return map;
    }
}