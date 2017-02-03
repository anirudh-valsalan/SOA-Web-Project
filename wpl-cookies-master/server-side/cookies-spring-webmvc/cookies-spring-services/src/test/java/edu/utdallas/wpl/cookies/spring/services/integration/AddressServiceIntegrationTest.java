package edu.utdallas.wpl.cookies.spring.services.integration;

import static edu.utdallas.wpl.cookies.spring.common.dto.samples.Addresses.ADDRESS_1;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import edu.utdallas.wpl.cookies.spring.services.config.CustomizedJacksonMapper;

/**
 * A sophisticated test-bed for front end testing.
 */
@Ignore
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressServiceIntegrationTest extends AbstractContextControllerTests {

	private MockMvc mockMvc;
	
	@Autowired
	private CustomizedJacksonMapper jacksonMapper;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void a_testCreateEvent() throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(post("/api/address").with(new RequestPostProcessor() {
					public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
						request.setRemoteAddr("127.0.0.1");
						return request;
					}})
				.contentType(MediaType.APPLICATION_JSON).content(ADDRESS_1.toString()))
				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.eventName", equalTo(CREATE_EVENT.getEventName())))
				.andReturn();
	}

	@Test
	public void b_testUpdateEvent() throws Exception {}
	
	@Test
	public void c_testGetEvent() throws Exception {}
	
	@Test
	public void c_testGetEvents() throws Exception {}
	
	@Test
	public void d_testDeleteEvent() throws Exception {}
	
}