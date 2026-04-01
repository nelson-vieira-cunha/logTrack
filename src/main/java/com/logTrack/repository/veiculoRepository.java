package com.example.logitrack.repository;

import com.example.logitrack.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.*;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {}