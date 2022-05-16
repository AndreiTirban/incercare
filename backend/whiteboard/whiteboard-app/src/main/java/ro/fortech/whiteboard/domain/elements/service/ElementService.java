package ro.fortech.whiteboard.domain.elements.service;

import org.springframework.stereotype.Service;
import ro.fortech.whiteboard.domain.elements.dto.ElementRequestDto;
import ro.fortech.whiteboard.domain.elements.dto.ElementResponseDto;

import javax.validation.Valid;

@Service
public interface ElementService {

    ElementResponseDto createElement(@Valid ElementRequestDto elementRequestDto);

    ElementResponseDto getElementById(String id);

    void updateElementById(@Valid ElementRequestDto elementRequestDto);

    void deleteElementById(String id);
}
