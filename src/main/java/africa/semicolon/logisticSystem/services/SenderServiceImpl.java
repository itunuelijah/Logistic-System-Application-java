package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.repositories.SenderRepository;
import africa.semicolon.logisticSystem.data.repositories.SenderRepositoryImpl;
import africa.semicolon.logisticSystem.dto.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dto.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.exception.DuplicateUserException;
import africa.semicolon.logisticSystem.exception.UserDoesNotExistException;
import africa.semicolon.logisticSystem.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

import static africa.semicolon.logisticSystem.utils.ModelMapper.map;

public class SenderServiceImpl implements  SenderService{
    private static final SenderRepository senderRepository = new SenderRepositoryImpl();

    @Override
    public RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest) {
        Optional<Sender> senderInDB = senderRepository.findSenderByEmail(registerSenderRequest.getSenderEmail());
        if (senderInDB.isPresent())
            throw new DuplicateUserException(registerSenderRequest.getSenderEmail() + "already exist");
        //convert to sender
        Sender sender = ModelMapper.map(registerSenderRequest);
//       save sender
        Sender savedSender = senderRepository.save(sender);
//       convert sender to dto

//       return dto
        return ModelMapper.map(savedSender);
    }
        @Override
        public List<Sender> getSenders() {
        return senderRepository.findAll();
    }

        @Override
        public void deleteAllSenders() {
            senderRepository.deleteAll();
        }

        @Override
        public Optional<Sender> findSenderByEmail(String email) {
            if(!senderRepository.findSenderByEmail(email).isPresent()) throw new UserDoesNotExistException("Sender does not exist");
            return senderRepository.findSenderByEmail(email);
        }
    }
