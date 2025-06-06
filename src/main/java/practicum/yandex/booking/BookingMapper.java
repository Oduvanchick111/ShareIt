package practicum.yandex.booking;

public class BookingMapper {
    public BookingDao toBookingDao(BookingDto bookingDto) {
        return BookingDao.builder()
                .start(bookingDto.getStart())
                .end(bookingDto.getEnd())
                .bookerId(bookingDto.getBookerId())
                .itemId(bookingDto.getItemId())
                .status(bookingDto.getStatus())
                .build();
    }
}
