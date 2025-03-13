package com.maxima.chat.restController;

import static com.maxima.chat.config.API.CITIES;

import com.maxima.chat.dto.CityCreateDto;
import com.maxima.chat.dto.CityViewDto;
import com.maxima.chat.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Рест контроллер для работы с городами
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(CITIES)
@Tag(name = "Города", description = "Операции по работе с городами")
public class CityController {

  private final CityService cityService;

  @GetMapping
  @Operation(summary = "Получение списка городов")
  public ResponseEntity<List<CityViewDto>> getList() {
    return ResponseEntity.ok(cityService.getList());
  }

  @PostMapping
  @Operation(summary = "Добавление города")
  public ResponseEntity<CityViewDto> addCity(@RequestBody CityCreateDto dto) {
    return ResponseEntity.ok(cityService.create(dto));
  }
}
