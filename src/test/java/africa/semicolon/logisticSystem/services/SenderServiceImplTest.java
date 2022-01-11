package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.dto.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dto.responses.RegisterSenderResponse;
import africa.semicolon.logisticSystem.exception.DuplicateUserException;
import africa.semicolon.logisticSystem.exception.UserDoesNotExistException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SenderServiceImplTest {
private SenderService senderService;
    @BeforeEach
    void setUp() {
        senderService = new SenderServiceImpl();
    }

    @AfterEach
    void tearDown(){
        senderService.deleteAllSenders();
    }

    @Test
    void registerSender() {
        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("Jerry");
        registerSenderRequest.setSenderEmail("jerry@gmail.com");
        registerSenderRequest.setPhoneNumber("1234567");
        RegisterSenderResponse response = senderService.registerSender(registerSenderRequest);
        assertEquals(response.getSenderEmail(), registerSenderRequest.getSenderEmail());
        assertEquals(1, senderService.getSenders().size());

    }
    public  RegisterSenderResponse registerSenderTestHelper(){
        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("Jerry");
        registerSenderRequest.setSenderEmail("jerry@gmail.com");
        registerSenderRequest.setPhoneNumber("0901234567");
        RegisterSenderResponse response = senderService.registerSender(registerSenderRequest);
        return  response;
    }
    @Test
    void duplicateEmail_throwsException(){
        registerSenderTestHelper();
        assertThrows(DuplicateUserException.class, () -> registerSenderTestHelper());
    }

    @Test
    void nonExistingSenderEmail_throwsException(){
        registerSenderTestHelper();
        assertThrows(UserDoesNotExistException.class, () -> senderService.findSenderByEmail("toska@gmail.com"));
    }
}