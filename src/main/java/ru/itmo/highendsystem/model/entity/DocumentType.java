package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Тип документа, удостоверяющего личность человека
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "document_type")
public class DocumentType {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(max = 255, message = "Имя типа документа не должно содержать более 255 символов")
    private String name;
}
