package com.practice.springtest.controllers;


import com.practice.springtest.domains.APIResponse;
import com.practice.springtest.models.User;
import com.practice.springtest.models.dtos.UserDTO;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntergrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll_Success() throws JSONException {
        String response = this.restTemplate.getForObject("/users", String.class);
        JSONAssert.assertEquals("[{id:2}]", response, false);
    }

    @Test
    public void getById_successObject() {
       User user = this.restTemplate.getForObject("/users/2", User.class);
       assertEquals(2, user.getId());
    }

    @Test
    public void getById_notFound() {
        ResponseEntity<APIResponse> user = this.restTemplate.getForEntity("/users/3", APIResponse.class);
        assertEquals(404, user.getStatusCodeValue());
        assertFalse(user.getBody().isStatus());
        assertEquals("User not found", user.getBody().getMessage());
    }

    @Test
    public void createUser_notFound() {
        UserDTO dto = new UserDTO("email@ds", "Divin", "Irakiza", "ADMIN");

        ResponseEntity<User> response = this.restTemplate.postForEntity("/users", dto, User.class);

        assertEquals(201, response.getStatusCodeValue());
//        assertEquals(dto, response.getBody());
    }

}
