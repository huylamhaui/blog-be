package lamph11.blogbe.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApiResponse {

    private int code;
    private String message;
    private Object payload;

    public static ApiResponse success(Object payload) {
        return new ApiResponse()
            .setCode(200)
            .setPayload(payload);
    }


    public static ApiResponse error(Throwable t) {
        return new ApiResponse()
            .setCode(400)
            .setMessage(t.getMessage())
            .setPayload(t);
    }
}
