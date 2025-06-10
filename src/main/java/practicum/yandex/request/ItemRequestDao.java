package practicum.yandex.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDao {
    private Long id;
    private String description;
    private Long requestorId;
    private LocalDate created;
}
