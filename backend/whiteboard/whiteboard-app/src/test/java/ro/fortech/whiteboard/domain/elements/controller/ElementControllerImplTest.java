/* package ro.fortech.whiteboard.domain.elements.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ro.fortech.whiteboard.domain.elements.ElementDataProvider;
import ro.fortech.whiteboard.domain.elements.dto.ElementRequestDto;
import ro.fortech.whiteboard.domain.elements.dto.ElementResponseDto;
import ro.fortech.whiteboard.domain.elements.rest.ElementControllerImpl;
import ro.fortech.whiteboard.domain.elements.service.ElementServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = {ElementControllerImpl.class, ElementServiceImpl.class})
class ElementControllerImplTest {

    private ElementRequestDto elementRequestDto = new ElementRequestDto();
    private ElementResponseDto elementResponseDto = new ElementResponseDto();

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ElementServiceImpl elementServiceImpl;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        elementRequestDto = ElementDataProvider.getElementRequestDtoMock();
        elementResponseDto = ElementDataProvider.getElementResponseDtoMock();
    }

    @Test
    void testCreateAnElement() throws Exception {
        when(elementServiceImpl.createElement(any(ElementRequestDto.class))).thenReturn(elementResponseDto);
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/element/create")
                                .content(mapper.writeValueAsString(elementRequestDto))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(elementRequestDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.text").value(elementRequestDto.getText()))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAnElementById() throws Exception {
        when(elementServiceImpl.getElementById(anyString())).thenReturn(elementResponseDto);
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/element/find/" + elementRequestDto.getId())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(elementResponseDto.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.text").value(elementResponseDto.getText()))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteAnElementById() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/element/delete/" + elementRequestDto.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateAnElementById() throws Exception {
        String request = mapper.writeValueAsString(elementRequestDto);
        mockMvc.perform(
                        MockMvcRequestBuilders.put("/element/update")
                                .content(request)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



} */
