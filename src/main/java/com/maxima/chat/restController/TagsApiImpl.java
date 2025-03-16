package com.maxima.chat.restController;

import com.maxima.chat.controller.TagsApiDelegate;
import com.maxima.chat.dto.TagCreateDto;
import com.maxima.chat.dto.TagViewDto;
import com.maxima.chat.service.TagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Реализация апи для работы с тегами
 */
@Service
@RequiredArgsConstructor
public class TagsApiImpl implements TagsApiDelegate {

  private final TagService tagService;

  @Override
  public ResponseEntity<List<TagViewDto>> getTags() {
    return ResponseEntity.ok(tagService.getList());
  }

  @Override
  public ResponseEntity<TagViewDto> tagCreation(TagCreateDto tagCreateDto) {
    return ResponseEntity.ok(tagService.create(tagCreateDto));
  }

  @Override
  public ResponseEntity<TagViewDto> updateTag(Integer id, TagCreateDto tagCreateDto) {
    return ResponseEntity.ok(tagService.update(id, tagCreateDto));
  }

  @Override
  public ResponseEntity<Void> deleteTag(Integer id) {
    tagService.delete(id);
    return ResponseEntity.ok().build();
  }
}
