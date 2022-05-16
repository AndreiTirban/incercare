package ro.fortech.whiteboard.domain.elements;

import lombok.experimental.UtilityClass;
import ro.fortech.whiteboard.domain.elements.dto.ElementRequestDto;
import ro.fortech.whiteboard.domain.elements.dto.ElementResponseDto;
import ro.fortech.whiteboard.domain.elements.service.model.Element;

@UtilityClass
public class ElementDataProvider {

    private final String elementId = "6ff96784-b572-4ada-b430-713819f0128b";
    private final String elementText = "This is a test.";

    public static Element getElementMock() {
        Element element = new Element();
        element.setId(elementId);
        element.setText(elementText);
        return element;
    }

    public static ElementRequestDto getElementRequestDtoMock() {
        ElementRequestDto elementRequestDto = new ElementRequestDto();
        elementRequestDto.setId(elementId);
        elementRequestDto.setText(elementText);
        return elementRequestDto;
    }

    public static ElementResponseDto getElementResponseDtoMock() {
        ElementResponseDto elementResponseDto = new ElementResponseDto();
        elementResponseDto.setId(elementId);
        elementResponseDto.setText(elementText);
        return elementResponseDto;
    }
}
