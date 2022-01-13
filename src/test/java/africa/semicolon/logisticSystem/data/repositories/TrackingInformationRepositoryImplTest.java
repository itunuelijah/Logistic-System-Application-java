package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.TrackingData;
import africa.semicolon.logisticSystem.data.models.TrackingInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrackingInformationRepositoryImplTest {
   TrackingInformationRepository trackingInformationRepository;
    @BeforeEach
    void setUp() {
        trackingInformationRepository = new TrackingInformationRepositoryImpl();
    }

    @Test
    void save() {
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(12345678);
        TrackingData trackingData = new TrackingData("Package Ready For dispatch");
        trackingInformation.getTrackingData().add(trackingData);
        TrackingInformation savedInfo = trackingInformationRepository.save(trackingInformation);
        assertEquals(savedInfo, trackingInformation);
        assertEquals(1, trackingInformationRepository.findAll().size());
    }

    private TrackingInformation saveTestHelper(){
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(12345678);
        TrackingData trackingData = new TrackingData("Package Ready For dispatch");
        trackingInformation.getTrackingData().add(trackingData);
        TrackingInformation savedInfo = trackingInformationRepository.save(trackingInformation);
        return savedInfo;
    }

    @Test
    void findAll() {
        saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
    }

    @Test
    void deleteAll() {
        saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.deleteAll();
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void findByPackageId() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        Optional<TrackingInformation> optionalTrackingInformation = trackingInformationRepository.findByPackageId(savedTrackingInformation.getPackageId());
        assertTrue(optionalTrackingInformation.isPresent());
        assertEquals(savedTrackingInformation, optionalTrackingInformation.get());
    }

    @Test
    void delete() {
        TrackingInformation savedInfo = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedInfo.getPackageId());
        assertEquals(0, trackingInformationRepository.findAll().size());
    }
    @Test
    void testDelete(){
        TrackingInformation savedInfo = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.delete(savedInfo);
        assertEquals(0, trackingInformationRepository.findAll().size());
    }
}