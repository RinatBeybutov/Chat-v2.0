package com.maxima.chat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность сообщения
 */
@Entity
@Getter
@Setter
@Table(name = "messages")
@NoArgsConstructor
public class MessageEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "message")
  private String message;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "user_id", insertable = false, updatable = false)
  private Integer userId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;
}
