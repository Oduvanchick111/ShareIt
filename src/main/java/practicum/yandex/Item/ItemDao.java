package practicum.yandex.Item;

import lombok.*;
import practicum.yandex.request.ItemRequestDao;
import practicum.yandex.user.UserDao;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDao {
    private Long id;
    private String name;
    private String description;
    private UserDao owner;
    private ItemRequestDao Request;
}
