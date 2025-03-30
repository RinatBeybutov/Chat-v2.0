package com.maxima.chat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * Родительская сущность для всех сущностей
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "uuid")
  private UUID uuid;

  @PrePersist
  private void genUuid() {
    this.uuid = UUID.randomUUID();
  }
}
