package com.mendonca.springassignmentac.vendaTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mendonca.springassignmentac.controller.VendaController;
import com.mendonca.springassignmentac.entity.Venda;
import com.mendonca.springassignmentac.repository.VendaRepository;
import com.mendonca.springassignmentac.service.VendaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(VendaController.class)
public class VendaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private VendaRepository vendaRepository;

    @Mock
    private VendaService vendaService;

    @Test
    public void testListVendas() throws Exception {
        List<Venda> vendaList = new ArrayList<>();
        vendaList.add(new Venda(1,200, "Rodrigo", "Angela"));
        vendaList.add(new Venda(2,2333.0, "Francisco", "Reinaldo"));
        vendaList.add(new Venda(3,42, "Roberta", "Angela"));

        Mockito.when(vendaRepository.findAll()).thenReturn(vendaList);
        String url = "/vendas";



        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(vendaList);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
    }

    @Test
    public void testCreateVenda() throws Exception {
        Venda newVenda = new Venda(2333.0, "Francisco", "Reinaldo");
        Venda savedVenda = new Venda(1,2333.0, "Francisco", "Reinaldo");

        Mockito.when(vendaRepository.save(newVenda)).thenReturn(savedVenda);

        String url = "/addVenda";
        mockMvc.perform(post(url)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(newVenda)))
                .andExpect(status().isOk()).andExpect(content().string("1"));
    }

    @Test
    public void testUpdateVenda() throws Exception {
        Venda existingVenda = new Venda(1,2333.0, "Rodrigo", "Matheus");
        Venda savedVenda = new Venda(1,2333.0, "Rodrigo", "Matheus");

        Mockito.when(vendaRepository.save(existingVenda)).thenReturn(savedVenda);

        String url = "/update";
        mockMvc.perform(put(url)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(existingVenda)))
                .andExpect(status().isOk()).andExpect(content().string("1"));
    }

    @Test
    public void testDeleteVenda() throws Exception {
        Integer vendaId = 1;

        Mockito.doNothing().when(vendaRepository).deleteById(vendaId);

        String url = "/delete/" + vendaId;

        mockMvc.perform(delete(url)).andExpect(status().isOk());

        Mockito.verify(vendaRepository).deleteById(vendaId);
    }

}
