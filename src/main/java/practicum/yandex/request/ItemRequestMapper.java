package practicum.yandex.request;

public class ItemRequestMapper {
    public ItemRequestDao toItemRequestDao(ItemRequestDto itemRequestDto) {
        return ItemRequestDao.builder()
                .description(itemRequestDto.getDescription())
                .created(itemRequestDto.getCreated())
                .requestorId(itemRequestDto.getRequestorId())
                .build();
    }
}
