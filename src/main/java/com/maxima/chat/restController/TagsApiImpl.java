package com.maxima.chat.restController;

import com.maxima.chat.controller.TagsApiDelegate;
import com.maxima.chat.dto.TagViewDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Реализация апи для работы с тегами
 */
@Service
public class TagsApiImpl implements TagsApiDelegate {

  @Override
  public ResponseEntity<List<TagViewDto>> tagsGet() {
    return ResponseEntity.ok(getList());
  }

  private List<TagViewDto> getList() {
    TagViewDto dog = new TagViewDto(1, "Собачник");
    TagViewDto gamer = new TagViewDto(1, "Геймер");
    return List.of(dog, gamer);
  }
}
