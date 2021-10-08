package com.crossover.profile.endpoints;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ProfileApplication;
import com.crossover.profile.model.Role;
import com.crossover.profile.model.UserAccount;
import com.crossover.profile.services.IUserAccountService;
import com.google.gson.Gson;

/**
 * User account end point test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProfileApplication.class)
@WebAppConfiguration
public class UserAccountEndPointTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @InjectMocks
    private UserAccountEndPoint userEndPoint;

    @Mock
    private IUserAccountService userService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userEndPoint).build();
    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.UserAccountEndPoint#addNewUserAccount(UserAccount)}
     *
     * @throws Exception
     */
    @Test
    public void testCreateNewUser() throws Exception {

        when(userService.addNewUserAccount(Mockito.anyObject())).thenReturn(true);

        Gson gson = new Gson();
        String json = gson.toJson(handleUserAccount());

        mockMvc.perform(post("/api/user/addNewUserAccount").content(json).contentType(contentType))
                .andExpect(status().isCreated()).andExpect(content().contentType("application/json"));

    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.UserAccountEndPoint#addNewUserAccount(UserAccount)}
     *
     * @throws Exception
     */
    @Test
    public void testCreateNewUserFail() throws Exception {
        when(userService.addNewUserAccount(Mockito.anyObject())).thenThrow(new Exception("internal error"));

        Gson gson = new Gson();
        String json = gson.toJson(handleUserAccount());

        mockMvc.perform(post("/api/user/addNewUserAccount").content(json).contentType(contentType))
                .andExpect(status().isInternalServerError());

    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.UserAccountEndPoint#getUserAccountByUserName(String)}
     *
     * @throws Exception
     */
    @Test
    public void testGetAllUserDemands() throws Exception {

        when(userService.getUserAccountByUsername(Mockito.anyString())).thenReturn(getUserAccount());

        mockMvc.perform(get("/api/user/getUserByUserName").param("username", "test")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("email").value("semonsamir@gmail.com"));

    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.UserAccountEndPoint#getUserAccountByUserName(String)}
     *
     * @throws Exception
     */
    @Test
    public void testGetAllUserDemandsEmpty() throws Exception {
        mockMvc.perform(get("/api/user/getUserByUserName").param("username", "")).andExpect(status().isNoContent());
    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.UserAccountEndPoint#getUserAccountByUserName(String)}
     *
     * @throws Exception
     */
    @Test
    public void testGetAllUserDemandsFail() throws Exception {

        when(userService.getUserAccountByUsername(Mockito.anyString())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/user/getUserByUserName").param("username", "test"))
                .andExpect(status().isInternalServerError());

    }

    private UserAccount handleUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("semonsamir@gmail.com");
        userAccount.setEnabled(true);
        userAccount.setFullname("simon samir");
        userAccount.setPassword("test123");
        userAccount.setRoles(Role.USER);
        userAccount.setStatus("NEW");
        userAccount.setUsername("simon");

        return userAccount;

    }

    private UserAccount getUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("semonsamir@gmail.com");
        userAccount.setEnabled(true);
        userAccount.setFullname("simon samir");
        userAccount.setPassword("test123");
        userAccount.setRoles(Role.USER);
        userAccount.setStatus("NEW");
        userAccount.setUsername("simon");

        return userAccount;

    }

}
