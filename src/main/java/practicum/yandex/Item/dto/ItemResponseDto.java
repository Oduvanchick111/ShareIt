package practicum.yandex.Item.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ItemResponseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private Long ownerId;
    private Long requestId;
}
