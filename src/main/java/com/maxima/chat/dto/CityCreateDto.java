package com.maxima.chat.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Модель создания города
 */
@Data
public class CityCreateDto {
  @Schema(description = "Название города")
  private String name;
  @Schema(description = "Код города")
  private String phoneCode;
}
