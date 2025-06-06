package practicum.yandex.Item.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ItemRequestDto {
    @NotBlank
    @Size(max = 200)
    private String name;
    @NotBlank
    @Size(max = 200)
    private String description;
    @NotNull
    private Boolean available;
    @NotNull
    private Long ownerId;
    private Long requestId;
}
