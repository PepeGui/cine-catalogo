package com.org.cine.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "filmes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String titulo;
    private int anoLancamento;
    private String genero;
}
