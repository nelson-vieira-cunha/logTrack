package com.logTrack.repository;

import com.logTrack.entity.Veiculo;
import org.springframework.data.jpa.repository.*;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {}