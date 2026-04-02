package com.logTrack.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "viagens")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private com.logTrack.entity.Veiculo veiculo;

    @Column(name = "data_saida", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataSaida;


    @Column(name = "data_chegada")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataChegada;

    private String origem;
    private String destino;

    @Column(name = "km_percorrida")
    private Double kmPercorrida;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public com.logTrack.entity.Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(com.logTrack.entity.Veiculo veiculo) { this.veiculo = veiculo; }
    public LocalDateTime getDataSaida() { return dataSaida; }
    public void setDataSaida(LocalDateTime dataSaida) { this.dataSaida = dataSaida; }
    public LocalDateTime getDataChegada() { return dataChegada; }
    public void setDataChegada(LocalDateTime dataChegada) { this.dataChegada = dataChegada; }
    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public Double getKmPercorrida() { return kmPercorrida; }
    public void setKmPercorrida(Double kmPercorrida) { this.kmPercorrida = kmPercorrida; }
}