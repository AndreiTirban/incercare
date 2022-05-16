package ro.fortech.whiteboard.domain.elements.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ro.fortech.whiteboard.domain.elements.dto.ElementRequestDto;
import ro.fortech.whiteboard.domain.elements.dto.ElementResponseDto;
import ro.fortech.whiteboard.domain.elements.repository.ElementRepository;
import ro.fortech.whiteboard.domain.elements.rest.exception.ElementNotDeleted;
import ro.fortech.whiteboard.domain.elements.rest.exception.ElementNotFound;
import ro.fortech.whiteboard.domain.elements.rest.exception.ElementNotUpdated;
import ro.fortech.whiteboard.domain.elements.service.converter.ElementConverter;
import ro.fortech.whiteboard.domain.elements.service.model.Element;

import javax.validation.Valid;

@Log
@Service
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ElementServiceImpl implements ElementService {

    private final ElementRepository elementRepository;
    private final ElementConverter converter;

    @Override
    public ElementResponseDto createElement(@Valid ElementRequestDto elementRequestDto) {
        Element element = converter.requestDtoToEntity(elementRequestDto);
        elementRepository.save(element);
        log.info(String.format("New Element has been created, id: %s text: %s.", element.getId(), element.getText()));
        return converter.entityToResponseDto(element);
    }

    @Override
    public ElementResponseDto getElementById(String id) {
        Element element = elementRepository.findById(id)
                .orElseThrow(() -> {
                    throw new ElementNotFound(getExceptionMessage(id));
                });
        return converter.entityToResponseDto(element);
    }

    @Override
    public void updateElementById(@Valid ElementRequestDto elementRequestDto) {
        String elementId = elementRequestDto.getId();

        try {
            if (elementRepository.existsById(elementId)) {
                elementRepository.save(converter.requestDtoToEntity(elementRequestDto));
                log.info(String.format("Element: %s has new updated text: %s", elementId, elementRequestDto.getText()));
            } else throw new ElementNotFound(getExceptionMessage(elementId));
        } catch (Exception e) {
            throw new ElementNotUpdated(String.format("Element %s could not be updated.", elementId));
        }
    }

    @Override
    public void deleteElementById(String id) {
        try {
            if (elementRepository.existsById(id)) {
                log.info(String.format("Element: %s has been deleted.", id));
                elementRepository.deleteById(id);
            } else throw new ElementNotFound(getExceptionMessage(id));
        } catch (Exception e) {
            throw new ElementNotDeleted(String.format("Element with id: %s could not be deleted.", id));
        }
    }

    private String getExceptionMessage(String id) {
        return String.format("Element %s could not be found.", id);
    }
}
