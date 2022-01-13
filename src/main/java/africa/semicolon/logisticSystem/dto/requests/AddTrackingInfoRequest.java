package africa.semicolon.logisticSystem.dto.requests;

import lombok.Data;

@Data
public class AddTrackingInfoRequest {
    private Integer packageId;
    private String event;
}
