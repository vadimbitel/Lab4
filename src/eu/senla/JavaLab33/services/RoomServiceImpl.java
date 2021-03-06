package eu.senla.JavaLab33.services;


import eu.senla.JavaLab33.api.repositories.RoomRepository;
import eu.senla.JavaLab33.api.services.RoomService;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.repositories.RoomRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoomServiceImpl extends AbstractServiceImpl<Room> implements RoomService {

    private static RoomService instance;

    private static RoomRepository roomRepository;

    public RoomServiceImpl() {
        super(RoomRepositoryImpl.getInstance());
        roomRepository = (RoomRepository) abstractRepository;
    }

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomServiceImpl();
        }
        return instance;
    }

    @Override
    public void changeStatus(long id, RoomStatus roomStatus) {
        abstractRepository.get(id).ifPresent(room -> room.setStatus(roomStatus));
    }

    @Override
    public List<Room> getRoomsByStatus(RoomStatus roomStatus) {
        return abstractRepository.getAll()
                .stream()
                .filter(room -> room.getStatus() == roomStatus)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getRoomsByCapacity(int capacity) {
        return abstractRepository.getAll()
                .stream()
                .filter(room -> room.getCapacity() >= capacity)
                .collect(Collectors.toList());
    }

    @Override
    public void changePrice(long id, double price) {
        abstractRepository.get(id).ifPresent(room -> room.setPrice(price));
    }

    @Override
    public List<Room> sortFreeByKey(Comparator<Room> comparator) {
        return roomRepository.getFreeRooms()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public int numberOfFreeRooms() {
        return roomRepository.getFreeRooms().size();
    }

}