package ro.fortech.whiteboard.domain.elements.rest;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.fortech.whiteboard.domain.elements.ElementController;
import ro.fortech.whiteboard.domain.elements.dto.ElementRequestDto;
import ro.fortech.whiteboard.domain.elements.dto.ElementResponseDto;
import ro.fortech.whiteboard.domain.elements.service.ElementServiceImpl;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Tag(name = "Element API", description = "<h4> Element API performing CRUD operations </h4>")
public class ElementControllerImpl implements ElementController {

    private final ElementServiceImpl elementServiceImpl;

    @Override
    public ElementResponseDto createElement(@RequestBody ElementRequestDto elementRequestDto) {
        return elementServiceImpl.createElement(elementRequestDto);
    }

    @Override
    public ElementResponseDto getElementById(@PathVariable @Parameter(description = "Id of the element that we want to get",
            example = "4b145d36-11e7-412f-87ef-8e30fac52788",
            required = true) String id) {
        return elementServiceImpl.getElementById(id);
    }

    @Override
    public void updateElementById(@RequestBody ElementRequestDto elementRequestDto) {
        elementServiceImpl.updateElementById(elementRequestDto);
    }

    @Override
    public void deleteElementById(@PathVariable @Parameter(description = "Id of the element that we want to delete",
            example = "4b145d36-11e7-412f-87ef-8e30fac52788",
            required = true) String id) {
        elementServiceImpl.deleteElementById(id);
    }
}
