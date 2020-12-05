package lamph11.blogbe.dto;

import lamph11.blogbe.common.PaginationRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FilterMenuRequest extends PaginationRequest{
    
    protected String keyword;
}
