package africa.semicolon.logisticSystem.utils;

import africa.semicolon.logisticSystem.data.models.Package;
import africa.semicolon.logisticSystem.data.models.Sender;
import africa.semicolon.logisticSystem.data.models.TrackingData;
import africa.semicolon.logisticSystem.dto.requests.AddPackageRequest;
import africa.semicolon.logisticSystem.dto.requests.AddTrackingInfoRequest;
import africa.semicolon.logisticSystem.dto.requests.RegisterSenderRequest;
import africa.semicolon.logisticSystem.dto.responses.AddPackageResponse;
import africa.semicolon.logisticSystem.dto.responses.AddTrackingInfoResponse;
import africa.semicolon.logisticSystem.dto.responses.RegisterSenderResponse;
import lombok.Data;

@Data
public class ModelMapper {

    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setSenderEmail(addPackageRequest.getSenderEmail());
        aPackage.setDeliveryAddress(addPackageRequest.getDeliveryAddress());
        aPackage.setReceiverName(addPackageRequest.getReceiverName());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhone());
        aPackage.setNetWeight(addPackageRequest.getPackageWeight());
        return aPackage;
    }

    public static AddPackageResponse map(Package savedPackage){
        AddPackageResponse response = new AddPackageResponse();
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setReceiverPhone(savedPackage.getReceiverPhone());
        response.setPackageName(savedPackage.getName());
        response.setTrackingNumber(savedPackage.getId());
        return response;
    }
    public static Sender map(RegisterSenderRequest registerSenderRequest){
        //        convert to sender
        Sender sender = new Sender();
        sender.setSenderName(registerSenderRequest.getSenderName());
        sender.setPhoneNumber(registerSenderRequest.getPhoneNumber());
        sender.setEmailAddress(registerSenderRequest.getSenderEmail());
        return sender;
    }

    public static RegisterSenderResponse map(Sender sender){
         RegisterSenderResponse response = new RegisterSenderResponse();
         response.setSenderEmail(sender.getEmailAddress());
         return response;
    }

    public static AddTrackingInfoResponse map(TrackingData trackingData, AddTrackingInfoRequest addTrackingInfoRequest) {
        AddTrackingInfoResponse addTrackingInfoResponse = new AddTrackingInfoResponse();
        addTrackingInfoResponse.setPackageId(addTrackingInfoRequest.getPackageId());
        addTrackingInfoResponse.setEvent(trackingData.getEvent());
        addTrackingInfoResponse.setDateTime(trackingData.getDateTimeOfEvent());
        return addTrackingInfoResponse;
    }
}




