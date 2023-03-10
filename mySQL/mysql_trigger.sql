
CREATE SCHEMA IF NOT EXISTS `carpark` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

DELIMITER $$
USE `carpark`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `carpark`.`trip_ticket_number`
AFTER INSERT ON `carpark`.`ticket`
FOR EACH ROW
begin
	select count(*) into @trip from ticket where tripId = new.tripId;
    update carpark.trip set bookedTicketNumber = @trip where tripId = new.tripId;
end$$


DELIMITER ;

