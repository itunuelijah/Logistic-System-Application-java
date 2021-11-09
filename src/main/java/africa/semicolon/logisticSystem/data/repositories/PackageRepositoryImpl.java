package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;

import java.util.*;

public class PackageRepositoryImpl implements PackageRepository{
   private final Map<Integer, Package > database =  new HashMap<>();
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
}
