package africa.semicolon.logisticSystem.data.repositories;

import africa.semicolon.logisticSystem.data.models.Package;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    PackageRepository packageRepository;
    @BeforeEach
    void setUp() {
        packageRepository = new PackageRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }
public void saveNewPackage(){
    Package aPackage = new Package();
    aPackage.setName("Sleeping Mat");
    aPackage.setSenderEmail("Jerry@email.com");
    aPackage.setReceiverName("Dami");
    aPackage.setReceiverPhone("08033310111");
    aPackage.setDeliveryAddress("312 Herbert Macaulay Way Sabo Yaba Lagos");
    aPackage.setNetWeight(23.5);

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
}