package lamph11.blogbe.service.specifications;

import org.springframework.data.jpa.domain.Specification;

import lamph11.blogbe.entity.Menu;
import lamph11.blogbe.entity.Menu_;

public class MenuSpecification {

    public static Specification<Menu> nameLike(String name) {
        return (root, query, builder) -> builder.like(root.get(Menu_.NAME), "%" + name + "%");
    }

    public static Specification<Menu> descriptionLike(String description) {
        return (root, query, builder) -> builder.like(root.get(Menu_.DESCRIPTION), "%" + description + "%");
    }
}
