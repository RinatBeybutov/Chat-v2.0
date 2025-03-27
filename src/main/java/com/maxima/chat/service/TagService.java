package com.maxima.chat.service;

import com.maxima.chat.dto.TagCreateDto;
import com.maxima.chat.dto.TagViewDto;
import com.maxima.chat.entity.TagEntity;
import com.maxima.chat.error.EntityNotFoundException;
import com.maxima.chat.mapper.TagMapper;
import com.maxima.chat.repository.TagRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Сервис для работы с Тегами.
 *
 * @author Gaben
 */
@Service
@RequiredArgsConstructor
public class TagService {

  private final TagRepository repository;

  private final TagMapper mapper;

  /**
   * Получение списка тегов из бд
   */
  @Transactional(readOnly = true)
  public List<TagViewDto> getList() {
    return repository.findAll()
        .stream()
        .map(mapper::toDto)
        .toList();
  }

  /**
   * Создание нового тега
   */
  @Transactional
  public TagViewDto create(TagCreateDto tagCreateDto) {
    TagEntity entity = new TagEntity();
    entity.setName(tagCreateDto.getName());
    entity = repository.save(entity);
    return mapper.toDto(entity);
  }

  /**
   * Обновление тега по id
   */
  @Transactional
  public TagViewDto update(Integer id, TagCreateDto tagCreateDto) {
    TagEntity entity = findTagById(id);
    entity.setName(tagCreateDto.getName());
    entity = repository.save(entity);
    return mapper.toDto(entity);
  }

  /**
   * Удаление тега по id
   */
  @Transactional
  public void delete(Integer id) {
    TagEntity entity = findTagById(id);
    repository.delete(entity);
  }

  private TagEntity findTagById(Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("error.tag_not_found.1", id));
  }
}
