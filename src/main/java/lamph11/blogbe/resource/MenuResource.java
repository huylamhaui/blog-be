package lamph11.blogbe.resource;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lamph11.blogbe.common.ApiResponse;
import lamph11.blogbe.common.ResponseUtils;
import lamph11.blogbe.dto.CreateMenuRequest;
import lamph11.blogbe.dto.FilterMenuRequest;
import lamph11.blogbe.dto.UpdateMenuRequest;
import lamph11.blogbe.entity.Menu;
import lamph11.blogbe.service.MenuService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/menu")
@AllArgsConstructor
public class MenuResource {

    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<ApiResponse> getPage(@ModelAttribute FilterMenuRequest filter) {
        try {
            Page<Menu> page = menuService.getPage(filter);
            return ResponseEntity.ok(ResponseUtils.success(page));
        } catch (Throwable t) {
            return ResponseEntity.ok(ResponseUtils.error(t));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody CreateMenuRequest request) {
        try {
            Menu menu = menuService.create(request);
            return ResponseEntity.ok(ResponseUtils.success(menu));
        } catch (Throwable t) {
            return ResponseEntity.ok(ResponseUtils.error(t));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody UpdateMenuRequest request) {
        try {
            Menu menu = menuService.update(request);
            return ResponseEntity.ok(ResponseUtils.success(menu));
        } catch (Throwable t) {
            return ResponseEntity.ok(ResponseUtils.error(t));
        }
    }
}
