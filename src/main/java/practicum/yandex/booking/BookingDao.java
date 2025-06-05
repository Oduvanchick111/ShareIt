package practicum.yandex.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practicum.yandex.Item.ItemDao;
import practicum.yandex.user.UserDao;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDao {
    private Long id;
    private LocalDate start;
    private LocalDate end;
    private ItemDao item;
    private UserDao booker;
    private Status status;
}
