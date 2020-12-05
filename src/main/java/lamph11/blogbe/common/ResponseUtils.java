package lamph11.blogbe.common;

import lombok.Data;

@Data
public class ResponseUtils {

    public static ApiResponse success(Object payload) {
        return new ApiResponse()
            .setCode(200)
            .setMessage("SUCCESS")
            .setPayload(payload);
    }


    public static ApiResponse error(Throwable t) {
        while(t.getCause() != null) {
            t = t.getCause();
        }
        return new ApiResponse()
            .setCode(400)
            .setMessage(t.getMessage())
            .setPayload(t);
    }
}
