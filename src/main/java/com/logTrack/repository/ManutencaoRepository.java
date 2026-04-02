package com.logTrack.repository;

import com.logTrack.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.List;


public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {


    @Query(value = """
    SELECT * FROM manutencoes
    WHERE data_inicio >= CURRENT_DATE
    ORDER BY data_inicio ASC
    LIMIT 5
     """, nativeQuery = true)
    List<Manutencao> proximasManutencoes();

    @Query(value = """
    SELECT v.placa, SUM(vi.km_percorrida) AS total_km
    FROM viagens vi
    JOIN veiculos v ON v.id = vi.veiculo_id
    GROUP BY v.placa
    ORDER BY total_km DESC
    LIMIT 1
""", nativeQuery = true)
    Object rankingUtilizacao();

    @Query(value = """
    SELECT SUM(custo_estimado)
    FROM manutencoes
    WHERE EXTRACT(MONTH FROM data_inicio) = EXTRACT(MONTH FROM CURRENT_DATE)
      AND EXTRACT(YEAR FROM data_inicio) = EXTRACT(YEAR FROM CURRENT_DATE)
""", nativeQuery = true)
    Double projecaoFinanceira();


}