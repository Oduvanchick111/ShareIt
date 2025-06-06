package practicum.yandex.Item.service;

import practicum.yandex.Item.dto.ItemRequestDto;
import practicum.yandex.Item.dto.ItemRequestForUpdateDto;
import practicum.yandex.Item.dto.ItemResponseDto;

import java.util.Collection;

public interface ItemService {
    ItemResponseDto saveItem(Long userId, ItemRequestDto itemRequestDto);
    ItemResponseDto updateItem (Long userId, Long itemId, ItemRequestForUpdateDto item);
    ItemResponseDto getItemById(Long userId, Long itemId);
    Collection<ItemResponseDto> getItemsByUserId(Long ownerId);
    ItemResponseDto getItemOnText (Long userId, String text);
}
