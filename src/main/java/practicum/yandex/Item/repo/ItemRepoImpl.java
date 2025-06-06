package practicum.yandex.Item.repo;

import lombok.Data;
import practicum.yandex.Item.model.ItemDao;
import practicum.yandex.exceptions.ValidateException;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class ItemRepoImpl implements ItemRepoInterface {

    private final Map<Long, ItemDao> allItems = new HashMap<>();

    @Override
    public ItemDao saveItem(ItemDao itemDao) {
        itemDao.setId(getNextId());
        allItems.put(itemDao.getId(), itemDao);
        return itemDao;
    }

    @Override
    public ItemDao updateItem(ItemDao item, Long ownerId) {
        if (!item.getOwnerId().equals(ownerId)) {
            throw new ValidateException("Вы не можете обновить эту вещь");
        } else {
            allItems.get(item.getId()).setName(item.getName());
            allItems.get(item.getId()).setDescription(item.getDescription());
            allItems.get(item.getId()).setAvailable(item.getAvailable());
        }
        return allItems.get(item.getId());
    }

    @Override
    public Optional<ItemDao> getItem(Long itemId) {
        return Optional.ofNullable(allItems.get(itemId));
    }

    @Override
    public Collection<ItemDao> getAllMyItems(Long ownerId) {
        return allItems.values().stream().filter(itemDao -> ownerId.equals(itemDao.getOwnerId())).collect(Collectors.toList());
    }

    @Override
    public Optional<ItemDao> getItemOnText(String text) {
        if (text == null || text.isBlank()) {
            return Optional.empty();
        }
        String searchText = text.toLowerCase();
        return allItems.values().stream()
                .filter(item -> item.getName().toLowerCase().contains(searchText) ||
                        (item.getDescription() != null && item.getDescription().toLowerCase().contains(searchText)))
                .findFirst();
    }

    private Long getNextId() {
        Collection<ItemDao> items = allItems.values();
        return items.isEmpty() ? 1L : items.stream()
                .mapToLong(ItemDao::getId)
                .max()
                .orElse(0) + 1;
    }
}
