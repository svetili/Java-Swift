import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	List<String> array;

	@Before
	public void setUp() throws Exception {
		array = new ArrayList<>(Arrays.asList(".bash_profile", "workspace.doc", "img0912.jpg", "updated_img0912.png",
				"documentation.html", "favicon.gif", "img0912.jpg.tmp", "access.lock"));
	}

	@Test
	public void testFilterFiles() {
		List<String> expectedArray = new ArrayList<>(Arrays.asList("img0912.jpg", "updated_img0912.png", "favicon.gif"));
		 assertEquals(expectedArray, FilterFiles.manageArray(array));
	}

}
