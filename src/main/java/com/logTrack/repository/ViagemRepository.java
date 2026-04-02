package com.logTrack.repository;


import com.logTrack.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.*;
import com.logTrack.entity.Viagem;


public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    // Total KM frota
    @Query(value = "SELECT COALESCE(SUM(km_percorrida),0) FROM viagens", nativeQuery = true)
    Double totalKmFrota();

    // Total KM por veículo
    @Query(value = "SELECT COALESCE(SUM(v.km_percorrida),0) FROM viagens v WHERE v.veiculo_id = :veiculoId", nativeQuery = true)
    Double totalKmPorVeiculo(@Param("veiculoId") Long veiculoId);

    // Volume por categoria (LEVE vs PESADO)
    @Query(value = "SELECT ve.tipo, COUNT(v.id) FROM viagens v JOIN veiculos ve ON v.veiculo_id = ve.id GROUP BY ve.tipo", nativeQuery = true)
    List<Object[]> volumePorCategoria();

    // Média KM
    @Query(value = "SELECT COALESCE(AVG(km_percorrida),0) FROM viagens", nativeQuery = true)
    Double mediaKm();

    // Total viagens
    @Query(value = "SELECT COUNT(*) FROM viagens", nativeQuery = true)
    Long totalViagens();

    @Query(value = """
    SELECT v.placa, SUM(vi.km_percorrida) AS total_km
    FROM viagens vi
    JOIN veiculos v ON v.id = vi.veiculo_id
    GROUP BY v.placa
    ORDER BY total_km DESC
    LIMIT 1
""", nativeQuery = true)
    Object rankingUtilizacao();

}