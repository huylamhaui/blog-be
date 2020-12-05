package lamph11.blogbe.common;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class PaginationRequest {

    protected int pageSize;
    protected int pageNumber;
    protected String sort;


    public Pageable buildPage() {
        if(pageSize <= 1) {
            pageSize = 50;
        }
        if(Objects.isNull(sort) || sort.isEmpty()) {
            return PageRequest.of(pageNumber, pageSize);
        }
        List<Sort.Order> orders = Arrays.asList(sort.split(",")).stream()
            .map(columnAndDirec -> {
                String splited[] = columnAndDirec.split(" ");
                if(splited.length == 1)
                    return Sort.Order.by(splited[0]);
                String column = splited[0];
                String direction = splited[1];
                if("DESC".equalsIgnoreCase(direction)){
                    return Sort.Order.desc(column);
                } else {
                    return Sort.Order.asc(column);
                }
            })
            .collect(Collectors.toList());
        Sort sort = Sort.by(orders);
        return PageRequest.of(pageNumber, pageSize, sort);
    }
}
