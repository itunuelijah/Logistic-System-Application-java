package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.dto.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dto.responses.RegisterSenderResponse;

import java.util.List;
import java.util.Optional;

public interface SenderService {
    RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest);
    List<Sender> getSenders();

    void deleteAllSenders();

    Optional<Sender> findSenderByEmail(String email);
}
