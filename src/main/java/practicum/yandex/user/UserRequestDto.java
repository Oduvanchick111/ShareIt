package practicum.yandex.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequestDto {
    @Email
    private String email;
    @NotBlank
    @Size(max = 200)
    private String name;
}
