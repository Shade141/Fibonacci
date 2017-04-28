package rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FibonacciApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	List<Object> list = new ArrayList<Object>();
	Integer[] a = {1,1,2,3,5,8};
	Integer[] b = {1,1,2,3,5,8,13,21,34,55,89,144,233,377,610};
	
    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {
    	list.addAll(Arrays.asList(a));
        this.mockMvc.perform(get("/calc")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultList").value(list));
    }
    
    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {
    	list.addAll(Arrays.asList(b));
        this.mockMvc.perform(get("/calc").param("top", "900"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.resultList").value(list));
    }

}