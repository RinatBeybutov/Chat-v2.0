package com.maxima.chat.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Модель представления города
 */
@Data
public class CityViewDto {
  @Schema(description = "Идентификатор города")
  private Integer id;
  @Schema(description = "Название города")
  private String name;
  @Schema(description = "Код города")
  private String phoneCode;
}
