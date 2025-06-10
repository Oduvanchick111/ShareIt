package practicum.yandex.Item.repo;

import practicum.yandex.Item.model.ItemDao;

import java.util.Collection;
import java.util.Optional;

public interface ItemRepoInterface {
    ItemDao saveItem(Long ownerId, ItemDao itemDao);

    ItemDao updateItem(Long itemId, ItemDao item);

    Optional<ItemDao> getItemById(Long ownerId, Long itemId);

    Collection<ItemDao> getItemByUserId(Long ownerId);

    Collection<ItemDao> getItemOnText(Long ownerId, String text);
}
