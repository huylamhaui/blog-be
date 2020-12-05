package lamph11.blogbe.service.specifications;

import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;

import lamph11.blogbe.entity.Menu;
import lamph11.blogbe.entity.Menu_;

public class MenuSpecification {

    public static Specification<Menu> nameLike(String name) {
        if(Objects.isNull(name) || name.isEmpty())
            return (root, query, builder) -> builder.conjunction();
        return (root, query, builder) -> builder.like(root.get(Menu_.NAME), "%" + name + "%");
    }

    public static Specification<Menu> descriptionLike(String description) {
        if(Objects.isNull(description) || description.isEmpty())
            return (root, query, builder) -> builder.conjunction();
        return (root, query, builder) -> builder.like(root.get(Menu_.DESCRIPTION), "%" + description + "%");
    }
}
