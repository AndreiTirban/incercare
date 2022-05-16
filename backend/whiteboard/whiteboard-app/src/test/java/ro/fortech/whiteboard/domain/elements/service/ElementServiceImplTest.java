package ro.fortech.whiteboard.domain.elements.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.fortech.whiteboard.domain.elements.ElementDataProvider;
import ro.fortech.whiteboard.domain.elements.dto.ElementRequestDto;
import ro.fortech.whiteboard.domain.elements.dto.ElementResponseDto;
import ro.fortech.whiteboard.domain.elements.repository.ElementRepository;
import ro.fortech.whiteboard.domain.elements.rest.exception.ElementNotDeleted;
import ro.fortech.whiteboard.domain.elements.rest.exception.ElementNotFound;
import ro.fortech.whiteboard.domain.elements.rest.exception.ElementNotUpdated;
import ro.fortech.whiteboard.domain.elements.service.converter.ElementConverter;
import ro.fortech.whiteboard.domain.elements.service.model.Element;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ElementServiceImplTest {

    private ElementRequestDto elementRequestDto;
    private ElementResponseDto elementResponseDto;
    private Element element;
    private String elementId;

    @InjectMocks
    private ElementServiceImpl elementService;

    @Mock
    private ElementRepository elementRepository;

    @Mock
    private ElementConverter elementConverter;

    @BeforeEach
    void setUp() {
        element = ElementDataProvider.getElementMock();
        elementRequestDto = ElementDataProvider.getElementRequestDtoMock();
        elementResponseDto = ElementDataProvider.getElementResponseDtoMock();
        elementId = elementRequestDto.getId();
    }

    @Test
    void testCreateAnElement() {
        when(elementConverter.entityToResponseDto(element)).thenReturn(elementResponseDto);
        when(elementRepository.save(element)).thenReturn(element);
        when(elementConverter.requestDtoToEntity(elementRequestDto)).thenReturn(element);
        ElementResponseDto equals = elementService.createElement(elementRequestDto);
        assertThat(equals.getText()).isEqualTo(elementResponseDto.getText());
        assertThat(equals.getId()).isEqualTo(elementResponseDto.getId());
    }

    @Test
    void testGetAnElementById() {
        when(elementRepository.findById(anyString())).thenReturn(Optional.of(element));
        when(elementConverter.entityToResponseDto(element)).thenReturn(elementResponseDto);
        ElementResponseDto grabbed = elementService.getElementById(elementRequestDto.getId());
        assertThat(grabbed.getId()).isEqualTo(elementResponseDto.getId());
        assertThat(grabbed.getText()).isEqualTo(elementResponseDto.getText());
    }

    @Test
    void testDeleteAnElementById() {
        when(elementRepository.existsById(anyString())).thenReturn(true);
        elementService.deleteElementById(elementRequestDto.getId());
        verify(elementRepository).deleteById(elementRequestDto.getId());
    }

    @Test
    void testUpdateAnElementById() {
        when(elementRepository.existsById(anyString())).thenReturn(true);
        when(elementConverter.requestDtoToEntity(any(ElementRequestDto.class))).thenReturn(element);
        elementService.updateElementById(elementRequestDto);
        verify(elementRepository).save(element);
    }

    @Test
    void should_throwElementNotDeletedError_when_deleteElementByIdFails() {
        when(elementRepository.existsById(anyString())).thenReturn(false);
        Exception exception =
                assertThrows(
                        ElementNotDeleted.class,
                        () -> {
                            elementService.deleteElementById(elementId);
                        });
        String message = exception.getMessage();
        String expected = "Element with id: " + elementId + " could not be deleted.";
        assertThat(expected).isEqualTo(message);
    }

    @Test
    void should_throwElementNotUpdatedError_when_updateElementByIdFails() {
        when(elementRepository.existsById(anyString())).thenReturn(false);
        Exception exception =
                assertThrows(
                        ElementNotUpdated.class,
                        () -> {
                            elementService.updateElementById(elementRequestDto);
                        });
        String message = exception.getMessage();
        String expected = "Element " + elementId + " could not be updated.";
        assertThat(expected).isEqualTo(message);
    }

    @Test
    void should_throwElementNotFoundError_when_getElementByIdFails() {
        Exception exception =
                assertThrows(
                        ElementNotFound.class,
                        () -> {
                            elementService.getElementById(elementId);
                        });
        String message = exception.getMessage();
        String expected = "Element " + elementId + " could not be found.";
        assertThat(expected).isEqualTo(message);
    }
}
