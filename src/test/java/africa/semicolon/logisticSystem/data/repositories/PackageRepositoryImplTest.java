package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.dto.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.services.SenderService;
import africa.semicolon.logisticSystem.services.SenderServiceImpl;
import org.junit.jupiter.api.*;

import  org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    PackageRepository packageRepository;
    @BeforeEach
    void setUp() {
        packageRepository = new PackageRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }
public Package saveNewPackage(){
    Package aPackage = new Package();
    aPackage.setName("Sleeping Mat");
    aPackage.setSenderEmail("Jerry@email.com");
    aPackage.setReceiverName("Dami");
    aPackage.setReceiverPhone("08033310111");
    aPackage.setDeliveryAddress("312 Herbert Macaulay Way Sabo Yaba Lagos");
    aPackage.setNetWeight(23.5);

    return aPackage;
}
    @Test
    void saveNewPackageTest() {

        Package savedPackage = saveNewPackage();
        assertEquals(1, savedPackage.getId());
    }

    @Test
    void updatePackageTest() {

        Package savedPackage = saveNewPackage();
        savedPackage.setName("Sniper");
        Package updatedPackage = packageRepository.save(savedPackage);
        assertEquals(1, updatedPackage.getId());
    }

    @Test
    void findAll() {

        Package savedPackage = saveNewPackage();
        assertEquals(1, packageRepository.findAll().size());
    }

    @Test
    void delete() {

        Package savedPackage = saveNewPackage();
        assertEquals(1, packageRepository.findAll().size());
        packageRepository.delete(savedPackage);
        assertEquals(0, packageRepository.findAll().size());
    }

    @Test
    void deleteById() {

        Package savedPackage = saveNewPackage();
        assertEquals(1, packageRepository.findAll().size());
        packageRepository.delete(1);
        assertEquals(0, packageRepository.findAll().size());
    }

    @Test
    void findPackageByTrackingNumber() {
        Package savedPackage = saveNewPackage();
        assertEquals(savedPackage, packageRepository.findPackageById(1));
    }


    @Test
    void findPackageBySender(){
        Sender sender = new Sender();
        sender.setSenderName("Toska");
        sender.setPhoneNumber("0901234567");
        sender.setEmailAddress("toska@gmail.com");

        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName(sender.getSenderName());
        registerSenderRequest.setSenderEmail(sender.getEmailAddress());
        registerSenderRequest.setPhoneNumber(sender.getPhoneNumber());

        SenderService senderService = new SenderServiceImpl();
        senderService.registerSender(registerSenderRequest);

        Package aPackage = new Package();
        aPackage.setName("Sleeping Mat");
        aPackage.setSenderEmail(registerSenderRequest.getSenderEmail());
        aPackage.setReceiverName("Dami");
        aPackage.setReceiverPhone("08033310111");
        aPackage.setDeliveryAddress("312 Herbert Macaulay Way Sabo Yaba Lagos");
        aPackage.setNetWeight(23.5);

        Package savedPackage = packageRepository.save(aPackage);

        Package thePackage = packageRepository.findPackageBySenderEmail("toska@gmail.com");
        assertEquals(savedPackage, thePackage);
    }
}