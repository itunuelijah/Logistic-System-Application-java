package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.services.SenderService;
import africa.semicolon.logisticSystem.services.SenderServiceImpl;

import java.util.*;

public class PackageRepositoryImpl implements PackageRepository{
   private final Map<Integer, Package > database =  new HashMap<>();
    private final SenderService senderService = new SenderServiceImpl();

    @Override
    public Package save(Package aPackage) {
        Integer id = null;
        if(aPackage.getId() == null){
            id = database.size() + 1;
            aPackage.setId(id);
        }
        id = aPackage.getId();
        database.put(id, aPackage);
        return database.get(id);
    }


    @Override
    public List<Package> findAll() {
        List<Package> all = new ArrayList<>();
        Set<Integer> keys = database.keySet();
        for (Integer key : keys){
            all.add(database.get(key));
        }
        return all;
    }


    @Override
    public void delete(Package aPackage) {

        database.remove(aPackage.getId());
    }

    @Override
    public void delete(Integer id) {
        database.remove(id);
    }

    @Override
    public Package findPackageById(Integer id) {
        return  database.get(id);
    }

    @Override
    public Package findPackageBySenderEmail(String email) {
        Optional<Sender> sender = senderService.findSenderByEmail(email);
        Set<Integer> keys = database.keySet();
        for (Integer key : keys){
            if(Objects.equals(database.get(key).getSenderEmail(), sender.get().getEmailAddress()))
                return database.get(key);
        }
        return null;
    }
}
