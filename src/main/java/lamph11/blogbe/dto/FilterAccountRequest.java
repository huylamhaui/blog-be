package lamph11.blogbe.dto;

import lamph11.blogbe.common.PaginationRequest;
import lombok.Data;

@Data
public class FilterAccountRequest extends PaginationRequest{
    
    private String username;
    private Integer status;
}
