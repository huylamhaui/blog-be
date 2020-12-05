package lamph11.blogbe.service;

import static lamph11.blogbe.service.specifications.MenuSpecification.descriptionLike;
import static lamph11.blogbe.service.specifications.MenuSpecification.nameLike;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lamph11.blogbe.dto.CreateMenuRequest;
import lamph11.blogbe.dto.FilterMenuRequest;
import lamph11.blogbe.entity.Menu;
import lamph11.blogbe.repository.MenuRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class MenuService {

    private final MenuRepository menuRepository;

    public Page<Menu> getPage(FilterMenuRequest request) {
        String keyword = request.getKeyword();
        Pageable pageable = request.buildPage();
        Specification<Menu> spec = (nameLike(keyword))
            .or(descriptionLike(keyword));

        return menuRepository.findAll(spec, pageable);
    }


    public Menu create(CreateMenuRequest request) {
        Menu menu = new Menu()
            .setID(UUID.randomUUID().toString())
            .setName(request.getName())
            .setDescription(request.getDescription());
        menu = menuRepository.save(menu);
        return menu;
    }
}
