package com.maxima.chat.restController;

import com.maxima.chat.dto.CityCreateDto;
import com.maxima.chat.dto.CityViewDto;
import com.maxima.chat.service.CityService;
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
@RequestMapping("/api/v1/cities")
public class CityController {

  private final CityService cityService;

  @GetMapping
  public ResponseEntity<List<CityViewDto>> getList() {
    return ResponseEntity.ok(cityService.getList());
  }

  @PostMapping
  public ResponseEntity<CityViewDto> addCity(@RequestBody CityCreateDto dto) {
    return ResponseEntity.ok(cityService.create(dto));
  }
}
