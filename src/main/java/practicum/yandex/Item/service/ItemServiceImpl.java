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
import practicum.yandex.exceptions.ValidateException;
import practicum.yandex.user.model.UserDao;
import practicum.yandex.user.repo.UserRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepoImpl itemRepo;
    private final UserRepository userRepository;

    @Override
    public ItemResponseDto saveItem(Long userId, ItemRequestDto itemRequestDto) {
        UserDao owner = userRepository.findUserById(userId).orElseThrow(() -> new NotFoundException("Такого пользователя не существует"));
        ItemDao itemDao = ItemMapper.toItemDao(itemRequestDto);
        itemRepo.saveItem(userId, itemDao);
        return ItemMapper.toItemResponseDto(itemDao);
    }

    @Override
    public ItemResponseDto updateItem(Long userId, Long itemId, ItemRequestForUpdateDto item) {
        UserDao owner = userRepository.findUserById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        ItemDao itemDao = itemRepo.getItemById(userId, itemId)
                .orElseThrow(() -> new NotFoundException("Товар не найден"));
        if (!itemDao.getOwnerId().equals(owner.getId())) {
            throw new NotFoundException("Нельзя изменять чужой товар");
        }
        ItemDao updatedItem = ItemMapper.toItemDaoUpdate(item);
        itemRepo.updateItem(itemId, updatedItem);
        return ItemMapper.toItemResponseDto(updatedItem);
    }

    @Override
    public ItemResponseDto getItemById(Long userId, Long itemId) {
        return itemRepo.getItemById(userId, itemId)
                .map(ItemMapper::toItemResponseDto)
                .orElseThrow(() -> new NotFoundException("Такой товар не найден"));
    }

    @Override
    public Collection<ItemResponseDto> getItemsByUserId(Long ownerId) {
        if (userRepository.findUserById(ownerId).isEmpty()) {
            throw new ValidateException("Такого пользователя не существует");
        } else {
            return itemRepo.getItemByUserId(ownerId).stream()
                    .map(ItemMapper::toItemResponseDto)
                    .toList();
        }
    }

    @Override
    public Collection<ItemResponseDto> getItemOnText(Long userId, String text) {
        UserDao user = userRepository.findUserById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        return itemRepo.getItemOnText(userId, text).stream().map(ItemMapper::toItemResponseDto).toList();
    }
}
