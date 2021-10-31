
package com.usa.G14.Reto5.G14Reto5.interfaces;

import com.usa.G14.Reto5.G14Reto5.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author edgarchaparro
 */
public interface InterfaceReservation extends CrudRepository<Reservation, Integer> {

    public List<Reservation> findAllByStatus(String status);
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateFrom, Date dateTo);
    
    // select clientId, count(*) as "total" from reservacion group by cliendId order by total desc;
    @Query ("SELECT C.client, COUNT(C.client) from Reservation As C Group By C.client Order By Count(C.client) DESC")
    public List<Object[]> getCountClients();

}
