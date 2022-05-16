package ro.fortech.whiteboard.domain.elements.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import ro.fortech.whiteboard.domain.elements.ElementDataProvider;
import ro.fortech.whiteboard.domain.elements.dto.ElementRequestDto;
import ro.fortech.whiteboard.domain.elements.dto.ElementResponseDto;
import ro.fortech.whiteboard.domain.elements.service.converter.ElementConverter;
import ro.fortech.whiteboard.domain.elements.service.model.Element;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ElementConverterTest {

    private ElementRequestDto elementRequestDto;
    private ElementResponseDto elementResponseDto;
    private Element element;

    @InjectMocks
    private ElementConverter converter;

    @Mock
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        elementRequestDto = ElementDataProvider.getElementRequestDtoMock();
        elementResponseDto = ElementDataProvider.getElementResponseDtoMock();
        element = ElementDataProvider.getElementMock();
    }

    @Test
    void testConvertEntityToResponseDto() {
        when(mapper.map(element, ElementResponseDto.class)).thenReturn(elementResponseDto);
        ElementResponseDto elementResponseDto = converter.entityToResponseDto(element);
        assertThat(elementResponseDto.getId()).isEqualTo(element.getId());
        assertThat(elementResponseDto.getText()).isEqualTo(element.getText());
    }

    @Test
    void testConvertRequestDtoToEntity() {
        when(mapper.map(elementRequestDto, Element.class)).thenReturn(element);
        Element element = converter.requestDtoToEntity(elementRequestDto);
        assertThat(elementRequestDto.getId()).isEqualTo(element.getId());
        assertThat(elementRequestDto.getText()).isEqualTo(element.getText());
    }
}
