package prv.xsq.eco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import prv.xsq.eco.entities.Top10Category;
import prv.xsq.eco.mapper.DataMapper;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EcommerceApplicationTests {

	@Autowired
	private DataMapper dataMapper;

	@Test
	public void contextLoads() {
	}



}
