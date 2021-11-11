package africa.semicolon.logisticSystem.services;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.dto.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dto.responses.AddPackageResponse;

public interface PackageService {
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest);

    Package findMyPackageWithMy(Integer id);
}
