package Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.tools.jxc.gen.config.Config;

import demo.model.*;
import demo.services.AutoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class AutoServiceTest {
	@Autowired
	private AutoService aService;

	@Test
	public void autoCount() {
		assertThat(aService.length(), is(equalTo(275L)));
	}

	@Test
	public void autoLikeB() {
		List<AAuto> l = aService.findByNameLike("B%");
		assertThat(l.size(), is(equalTo(7)));
	}
	
	@Test
	public void autoLuxusklasse() {
		AAuto a = aService.findOne(1);
		assertThat(a.getAFahrzeugtyp(), is(equalTo("Luxusklasse")));
	}

}
