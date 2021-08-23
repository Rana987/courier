package com.example.migros.demo.service;

import com.example.migros.demo.dto.CourierLocationDto;
import com.example.migros.demo.dto.CourierLocationRequestDto;
import com.example.migros.demo.dto.StoresDto;
import com.example.migros.demo.repository.CourierRepository;
import com.example.migros.demo.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CourierService extends AbstractService {

    private static final Logger LOG = LoggerFactory.getLogger(CourierService.class);

    @Autowired
    private StoreService storeService;

    protected CourierService(CourierRepository repository) {
        super(repository);
    }


    @Transactional
    public void insertCourierLocation(CourierLocationRequestDto courierLocationRequestDto) {
        Double lat = courierLocationRequestDto.getLat();
        Double lng = courierLocationRequestDto.getLng();
        List<StoresDto> allStores = storeService.getAllStores();
        for (StoresDto store : allStores) {
            double distance = Utility.calculateDistance(lat, lng, store.getLat(), store.getLng());
            CourierLocationDto courierLocation = getCourierLocationByStore(courierLocationRequestDto.getCourierId(), store.getName());
            boolean hasAlreadyEntered = ChronoUnit.MINUTES.between(courierLocation.getEntranceDateTime(), LocalDateTime.now()) < 1;
            if (courierLocation.getStore().equals(store.getName()) && hasAlreadyEntered) {
                if (distance <= 100d) {
                    LOG.info("{} has entered to store {}", courierLocationRequestDto.getCourierId().toString(), store.getName());
                    return;
                }
            }
        }
    }


    @Transactional
    public double getTotalTravelDistance(Integer courierId) {
        List<CourierLocationDto> courierLocationList = getCourierLocationList(courierId);
        double totalDistance = 0;
        for(int i = 0; i < courierLocationList.size() -1; i++){
            totalDistance += Utility.calculateDistance(courierLocationList.get(i).getLat(), courierLocationList.get(i).getLng(), courierLocationList.get(i+1).getLat(), courierLocationList.get(i+1).getLng());
        }
        return totalDistance;
    }


    private CourierLocationDto getCourierLocationByStore(Integer courierId, String storeName) {
        //If i had a database level, i would like to take courierId and storeName as a filter value. Then it would be more easier and faster to search the data
        // Since i dont have a DB, i just created some mock data.
        Random r = new Random();
        double randomValue = r.nextDouble();
        return getCourierLocationDto(randomValue);
    }

    private CourierLocationDto getCourierLocationDto(double randomValue) {
        CourierLocationDto courierLocationDto = new CourierLocationDto();
        courierLocationDto.setEntranceDateTime(LocalDateTime.now().minusMinutes(1));
        courierLocationDto.setCourierId(1);
        courierLocationDto.setLat(randomValue+40);
        courierLocationDto.setLng(randomValue + 20d);
        courierLocationDto.setStore("Ataşehir MMM Migros");
        return courierLocationDto;
    }

    private List<CourierLocationDto> getCourierLocationList(Integer courierId) {
        CourierLocationDto mockLocation = getCourierLocationByStore(courierId, "tst");
        CourierLocationDto mockLocation2 = getCourierLocationByStore(courierId, "tst");
        CourierLocationDto mockLocation3 = getCourierLocationByStore(courierId, "tst");
        List<CourierLocationDto> courierLocationDtoList = new ArrayList<>();
        courierLocationDtoList.add(mockLocation);
        courierLocationDtoList.add(mockLocation2);
        courierLocationDtoList.add(mockLocation3);
        return courierLocationDtoList;
    }
}
