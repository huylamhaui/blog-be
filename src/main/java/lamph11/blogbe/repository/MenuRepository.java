package lamph11.blogbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import lamph11.blogbe.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String>, 
    JpaSpecificationExecutor<Menu> {

}
