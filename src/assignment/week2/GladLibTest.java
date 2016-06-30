package assignment.week2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GladLibTest {
	private GladLib gl;

	@Before
	public void setUp() throws Exception {
		this.gl = new GladLib();
	}

	@After
	public void tearDown() throws Exception {
		this.gl = null;
	}

	@Test
	public void test() {
		gl.makeStory();
	}

}
