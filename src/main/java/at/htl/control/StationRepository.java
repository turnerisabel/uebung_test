package at.htl.control;

import entity.Line;
import entity.Location;
import entity.Station;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StationRepository {

    @Inject
    EntityManager em;

    @Inject
    LineRepository lineRepository;

    @Inject
    LocationRepository locationRepository;


    @Transactional
    public Station save(Station station) {
        return em.merge(station);
    }

    /**
     * persist all stations from the List "stations" in the database
     *
     * @param lineName
     * @param stations
     */
    public void saveStationsFromLine(String lineName, List<String> stations) {
        Line line = lineRepository.findByName(lineName);
        Station prevStation = null;

        for (String station : stations) {
            Location location = locationRepository.findByName(station);
            Station station1 = new Station(line, location, prevStation);
            prevStation = save(station1);
        }
    }

    /**
     * find all stations per line in the database
     *
     * @param lineName
     * @return
     */
    public List<Station> stationsPerLine(String lineName) {
        try {
            TypedQuery<Station> query = em
                    .createNamedQuery("Station.stationsPerLine", Station.class)
                    .setParameter("LINE", lineName);
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
    }
}
