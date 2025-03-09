package com.maxima.chat.service;

import com.maxima.chat.dto.CityCreateDto;
import com.maxima.chat.dto.CityViewDto;
import com.maxima.chat.entity.CityEntity;
import com.maxima.chat.mapper.CityMapper;
import com.maxima.chat.repository.CityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для работы с городами
 */
@Service
@RequiredArgsConstructor
public class CityService {

  private final CityRepository repository;

  private final CityMapper mapper;

  @Transactional(readOnly = true)
  public List<CityViewDto> getList() {
    return repository.findAll()
        .stream()
        .map(mapper::toDto)
        .toList();
  }

  @Transactional
  public CityViewDto create(CityCreateDto dto) {
    var entity = mapper.toEntity(dto);
    entity = repository.save(entity);
    return mapper.toDto(entity);
  }
}
