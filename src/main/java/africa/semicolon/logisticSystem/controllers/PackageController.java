package africa.semicolon.logisticSystem.controllers;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.dto.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dto.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.exception.UserDoesNotExistException;
import africa.semicolon.logisticSystem.services.PackageService;
import africa.semicolon.logisticSystem.services.PackageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {
    private final PackageService packageService = new PackageServiceImpl();


    @PostMapping("/api/addPackage")
    public ResponseEntity<?> addPackage(@RequestBody AddPackageRequest addPackageRequest) {
        try {
            AddPackageResponse response = packageService.addPackage(addPackageRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UserDoesNotExistException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/package/{id}")
    public Package findPackageById(@PathVariable("id") Integer id) {
        return packageService.findMyPackageWithMy(id);
    }
}