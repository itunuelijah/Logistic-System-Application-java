package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.TrackingInformation;

import java.util.*;

public class TrackingInformationRepositoryImpl implements TrackingInformationRepository{
    private final Map<Integer, TrackingInformation> database = new HashMap<>();
    @Override
    public TrackingInformation save(TrackingInformation trackingInformation) {
        database.put(trackingInformation.getPackageId(), trackingInformation);
        return trackingInformation;
    }

    @Override
    public List<TrackingInformation> findAll() {
        Set<Integer> keys = database.keySet();
        List<TrackingInformation> all = new ArrayList<>();
        for (Integer key: keys) {
            all.add(database.get(key));
        }
        return all;
    }

    @Override
    public void deleteAll() {
        database.clear();
    }

    @Override
    public Optional<TrackingInformation> findByPackageId(Integer packageId) {
        if(database.containsKey(packageId)) return Optional.of(database.get(packageId));
        return Optional.empty();
    }

    @Override
    public void delete(Integer packageId) {
        database.remove(packageId);
    }

    @Override
    public void delete(TrackingInformation trackingInformation) {
        database.remove(trackingInformation.getPackageId());
    }
}
