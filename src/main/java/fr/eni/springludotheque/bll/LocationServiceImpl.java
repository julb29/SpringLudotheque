package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Location;
import fr.eni.springludotheque.dal.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location creationLocation(Location location) {
        locationRepository.save(location);
        return location;
    }



}
