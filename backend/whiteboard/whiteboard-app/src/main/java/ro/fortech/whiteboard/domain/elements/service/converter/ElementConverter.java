package ro.fortech.whiteboard.domain.elements.service.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.fortech.whiteboard.domain.elements.dto.ElementRequestDto;
import ro.fortech.whiteboard.domain.elements.dto.ElementResponseDto;
import ro.fortech.whiteboard.domain.elements.service.model.Element;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ElementConverter {

    private final ModelMapper mapper;

    public ElementResponseDto entityToResponseDto(Element element) {
        return mapper.map(element, ElementResponseDto.class);
    }

    public Element requestDtoToEntity(ElementRequestDto elementRequestDto) {
        return mapper.map(elementRequestDto, Element.class);
    }
}
