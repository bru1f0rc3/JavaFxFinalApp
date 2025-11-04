-- Исправление ошибки удаления бронирований
-- Проблема: ON DELETE SET NULL не работает для PRIMARY KEY
-- Решение: заменить на ON DELETE CASCADE

ALTER TABLE booking_additional_services 
DROP CONSTRAINT booking_additional_services_fk;

ALTER TABLE booking_additional_services 
ADD CONSTRAINT booking_additional_services_fk 
FOREIGN KEY (booking_id) REFERENCES bookings(booking_id) ON DELETE CASCADE;
