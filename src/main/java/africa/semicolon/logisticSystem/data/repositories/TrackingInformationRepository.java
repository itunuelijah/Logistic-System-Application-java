package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.TrackingInformation;

import java.util.List;
import java.util.Optional;

public interface TrackingInformationRepository {
    TrackingInformation save(TrackingInformation trackingInformation);
    List<TrackingInformation> findAll();
    void deleteAll();
    Optional<TrackingInformation> findByPackageId(Integer packageId);
    void delete(Integer packageId);
    void delete(TrackingInformation trackingInformation);
}
