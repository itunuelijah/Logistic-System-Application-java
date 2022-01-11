package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.repositories.PackageRepository;
import africa.semicolon.logisticSystem.data.repositories.PackageRepositoryImpl;
import africa.semicolon.logisticSystem.dto.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dto.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.exception.UserDoesNotExistException;
import africa.semicolon.logisticSystem.utils.ModelMapper;

import java.util.Optional;

public class PackageServiceImpl implements PackageService {
    private static final PackageRepository packageRepository = new PackageRepositoryImpl();
    private final SenderService senderService = new SenderServiceImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        Optional<Sender> senderOptional = senderService.findSenderByEmail(addPackageRequest.getSenderEmail());
        if (senderOptional.isEmpty()) throw new UserDoesNotExistException("Sender not registered");
        //convert addPackage request to a package
        Package aPackage = ModelMapper.map(addPackageRequest);

        //save package
        Package savedPackage = packageRepository.save(aPackage);

        //convert saved package to addPackage response
        AddPackageResponse response = ModelMapper.map(savedPackage);
        //return converted response
        return response;
    }

    @Override
    public Package findMyPackageWithMy(Integer id) {
        return packageRepository.findPackageById(id);
    }


    public Package findPackageWithSenderEmail(String email) {
        return packageRepository.findPackageBySenderEmail(email);
    }
}
