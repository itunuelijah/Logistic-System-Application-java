package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Sender;

import java.util.Collection;
import java.util.Optional;

public interface SenderRepository {

        Sender save(Sender sender);
        Optional<Sender> findSenderByEmail(String email);
        void delete(Sender sender);
        void delete(String email);
        list<Sender> findAll();
        void deleteAll();
}


