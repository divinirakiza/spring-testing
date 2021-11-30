package com.practice.springtest.controllers;


import com.practice.springtest.domains.APIResponse;
import com.practice.springtest.models.User;
import com.practice.springtest.models.dtos.AuthRequestDTO;
import com.practice.springtest.models.dtos.AuthResponseDTO;
import com.practice.springtest.models.dtos.UserDTO;
import com.practice.springtest.services.AuthService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(AuthController.class)
public class AuthControllerIntergrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authServiceMock;

    @Test
    public void login_success() throws Exception {
        AuthRequestDTO requestDTO = new AuthRequestDTO("email@ds.s", "123");

        when(authServiceMock.handleLogin(requestDTO)).thenReturn(new AuthResponseDTO(1, "Token"));

        MockHttpServletRequestBuilder makeRequest = MockMvcRequestBuilders.post("api/auth/login")
                .accept(MediaType.APPLICATION_JSON);
    }

}
