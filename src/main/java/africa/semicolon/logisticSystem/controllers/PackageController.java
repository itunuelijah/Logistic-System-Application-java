package africa.semicolon.logisticSystem.controllers;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.dto.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dto.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.services.PackageService;
import africa.semicolon.logisticSystem.services.PackageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageController {
    private PackageService packageService = new PackageServiceImpl();


    @PostMapping("/api/addPackage")
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        return packageService.addPackage(addPackageRequest);
    }

    @GetMapping("/api/package/{id}")
    public Package findPackageById(@PathVariable("id") Integer id) {
        return packageService.findMyPackageWithMy(id);
    }
}