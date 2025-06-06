package practicum.yandex.Item.repo;

import practicum.yandex.Item.model.ItemDao;

import java.util.Collection;
import java.util.Optional;

public interface ItemRepoInterface {
    ItemDao saveItem(ItemDao itemDao);
    ItemDao updateItem (ItemDao item, Long ownerId);
    Optional<ItemDao> getItem(Long itemId);
    Collection<ItemDao> getAllMyItems(Long ownerId);
    Optional<ItemDao> getItemOnText (String text);
}
