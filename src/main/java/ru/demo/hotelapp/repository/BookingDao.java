package ru.demo.hotelapp.repository;

import ru.demo.hotelapp.model.Booking;

public class BookingDao extends BaseDao<Booking> {
    public BookingDao() {
        super(Booking.class);
    }
}
