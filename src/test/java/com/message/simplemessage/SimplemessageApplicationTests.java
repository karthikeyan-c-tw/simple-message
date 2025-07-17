package com.message.simplemessage;

import com.message.simplemessage.entity.GreetingEntity;
import com.message.simplemessage.repository.GreetingRepository;
import com.message.simplemessage.service.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.Repository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SimplemessageApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private GreetingRepository greetingRepository;
    @Autowired
    private Repository repository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void testGetMessageInEnglish() throws Exception {
		GreetingEntity english = new GreetingEntity();
		english.setLanguage("en");
		english.setMessage("Welcome");
		greetingRepository.save(english);
		mockMvc.perform(get("/simple-message/message/en"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.Message").value("Welcome"));
	}

	@Test
	void testGetMessageInSpanish() throws Exception {
		GreetingEntity spanish = new GreetingEntity();
		spanish.setLanguage("es");
		spanish.setMessage("Ola");
		greetingRepository.save(spanish);
		mockMvc.perform(get("/simple-message/message/es"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.Message").value("Ola"));
	}

	@Test
	void testGetMessageDefault() throws Exception {
		mockMvc.perform(get("/simple-message/message/xx"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.Message").value("Hello"));
	}

}
