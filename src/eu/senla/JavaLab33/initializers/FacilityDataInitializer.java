package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.api.data.FacilityDataStorage;
import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.memodatastorage.FacilityDataStorageImpl;

import java.util.ArrayList;

public class FacilityDataInitializer implements Initializer {

    @Override
    public void init() {
        FacilityDataStorage facilityDataStorage = FacilityDataStorageImpl.getInstance();
        facilityDataStorage.setEntities(new ArrayList<>());

        FacilityController facilityController = FacilityController.getInstance();

        facilityController.createFacility("Abatoria", 250);
        facilityController.createFacility("Sauna", 178);
        facilityController.createFacility("Coffee", 31);
        facilityController.createFacility("Niko", 23);
        facilityController.createFacility("Chill", 46);
        facilityController.createFacility("Heat", 46);
        facilityController.createFacility("Drink", 58);
        facilityController.createFacility("Safe", 61);
        facilityController.createFacility("Massage", 95);
    }
}
