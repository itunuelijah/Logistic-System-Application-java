package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Sender;

import java.util.*;

public class SenderRepositoryImpl implements  SenderRepository {
    Map<String, Sender> database = new HashMap<>();

    @Override
    public  Sender save(Sender sender){
        database.put(sender.getEmailAddress(),sender);
        return sender;
    }

    @Override
    public Optional<Sender> findSenderByEmail(String email) {
        if(database.containsKey(email)) return Optional.of(database.get(email));
        return Optional.empty();
    }

    @Override
    public void delete(Sender sender) {
     delete(sender.getEmailAddress());
    }

    @Override
    public void delete(String email) {
        database.remove(email);
    }

    @Override
    public List<Sender> findAll(){
        list<Sender> all = new ArrayList<>();
        Set<String> keysInDB = database.keySet();
        for(String key: keysInDB){
            all.add(database.get(key));
        }
        return all;
    }

    @Override
    public void deleteAll() {
        database.clear();
    }
}


