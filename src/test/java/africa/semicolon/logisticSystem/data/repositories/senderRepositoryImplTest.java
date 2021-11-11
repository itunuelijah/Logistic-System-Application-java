package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Sender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class senderRepositoryImplTest {
SenderRepository senderRepository;

    @BeforeEach
    void setUp() {
    senderRepository = new senderRepositoryImpl();
    }

    @Test
    void save() {
    Sender sender = new Sender();
    sender.setSenderName("Jerry");
    sender.setEmailAddress("jerry@gmail.com");
    sender.setPhoneNumber("9993884");
    Sender savedSender = senderRepository.save(sender);
    assertEquals(sender, savedSender);
    assertEquals(1, senderRepository.findAll().size());
    }

   public Sender saveSender(){
       Sender sender = new Sender();
       sender.setSenderName("Jerry");
       sender.setEmailAddress("jerry@gmail.com");
       sender.setPhoneNumber("9993884");

       return senderRepository.save(sender);

   }

    @Test
    void findSenderByEmail() {
        Sender savedSender = saveSender();
        assertEquals(savedSender, senderRepository.findSenderByEmail(savedSender.getEmailAddress()).get());
    }

    @Test
    void delete() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender.getEmailAddress());
                assertEquals(0, senderRepository.findAll().size());
    }

    @Test
    void testDeleteBySender() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender);
        assertEquals(0, senderRepository.findAll().size());
//        assertTrue(0, senderRepository.findAll().isEmpty());
    }


}