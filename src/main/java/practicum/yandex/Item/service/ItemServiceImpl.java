package practicum.yandex.Item.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practicum.yandex.Item.dto.ItemRequestDto;
import practicum.yandex.Item.dto.ItemRequestForUpdateDto;
import practicum.yandex.Item.dto.ItemResponseDto;
import practicum.yandex.Item.mapper.ItemMapper;
import practicum.yandex.Item.model.*;
import practicum.yandex.Item.repo.ItemRepoImpl;
import practicum.yandex.exceptions.NotFoundException;
import practicum.yandex.user.UserService;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepoImpl itemRepo;
    private final UserService userService;

    @Override
    public ItemResponseDto saveItem(Long userId, ItemRequestDto itemRequestDto) {
        ItemDao itemDao = ItemMapper.toItemDao(itemRequestDto);
        itemRepo.saveItem(itemDao);
        return ItemMapper.toItemResponseDto(itemDao);
    }

    @Override
    public ItemResponseDto updateItem(Long userId, Long itemId, ItemRequestForUpdateDto item) {
        ItemDao itemDao = ItemMapper.toItemDaoUpdate(item);
        itemRepo.updateItem(itemDao, item.getOwnerId());
        return ItemMapper.toItemResponseDto(itemDao);
    }

    @Override
    public ItemResponseDto getItemById(Long userId, Long itemId) {
        return itemRepo.getItem(itemId)
                .map(ItemMapper::toItemResponseDto)
                .orElseThrow(() -> new NotFoundException("Такой товар не найден"));
    }

    @Override
    public Collection<ItemResponseDto> getItemsByUserId(Long ownerId) {
        return itemRepo.getAllMyItems(ownerId).stream()
                .map(ItemMapper::toItemResponseDto)
                .toList();
    }

    @Override
    public ItemResponseDto getItemOnText(Long userId, String text) {
        return itemRepo.getItemOnText(text).map(ItemMapper::toItemResponseDto).orElseThrow(()->new NotFoundException("Товара с таким описанием нет"));
    }
}
