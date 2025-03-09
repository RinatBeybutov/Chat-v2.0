package com.maxima.chat.dto;

import lombok.Data;

/**
 * Модель представления города
 */
@Data
public class CityViewDto {
  private Integer id;
  private String name;
  private String phoneCode;
}
