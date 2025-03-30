package com.maxima.chat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * Сущность тега
 */
@Getter
@Setter
@Entity
@Table(name = "tags")
public class TagEntity extends BaseEntity {
  @Column(name = "name")
  private String name;
}
