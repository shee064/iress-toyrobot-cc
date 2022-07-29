package com.si.iress.toyrobot.iresstoyrobot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import com.si.iress.toyrobot.trc.IressToyRobotApplication;
import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.MessageConstants;
/**
 * IressToyrobotApplicationTests - Test different set of commands for the robot
 * @author sheenai
 *
 */
@ExtendWith (OutputCaptureExtension.class)
class IressToyrobotApplicationTests {

	private SpringApplication springApp;
	private ToyRobot robot;
	
	@BeforeEach
	@Disabled
	void setUp() {
		springApp = new SpringApplication(IressToyRobotApplication.class);
		springApp.setBannerMode(Mode.OFF);
		springApp.setLogStartupInfo(false);
		robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH, MessageConstants.TBL_WIDTH));
		robot.setPosition(new Position(0,0));
		
	}
	
	@Test
	void whenContextLoads_thenAppIsNotNull() {
		assertNotNull(springApp);
	}
	
	@Test
	void whenFirstCommandIsNotPlace_thenMoveToTheNextUntilValidPlaceCommand(CapturedOutput output) {
		springApp.run("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_placenotfirstcmd.txt");
		assertTrue(output.getOut().contains("0,2,NORTH"));
	}
	
	@Test
	void whenMoreThanOnePlaceCommand_thenValid(CapturedOutput output) {
		springApp.run("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_multiplacecmd.txt");
		assertTrue(output.getOut().contains("0,3,WEST"));	
	}
	
	@Test
	void withInvalidCommand_thenIgnoreInvalidCommand(CapturedOutput output) {
		springApp.run("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_withinvalidcmd.txt");
		assertTrue( output.getOut().contains("1,3,SOUTH"));	
	}
	
	@Test
	void withValidCommand_thenExecute(CapturedOutput output) {
		springApp.run("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_validcmd.txt");
		assertTrue(output.getOut().contains("4,1,NORTH"));	
	}
	
	@Test
	void testAScenario(CapturedOutput output) {
		springApp.run("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_A.txt");
		assertTrue(output.getOut().contains("0,1,NORTH"));	
	}
	
	@Test
	void testBScenario(CapturedOutput output) {
		springApp.run("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_B.txt");
		assertTrue(output.getOut().contains("0,0,WEST"));	
	}
	
	@Test
	void testCScenario(CapturedOutput output) {
		springApp.run("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_C.txt");
		assertTrue(output.getOut().contains("3,3,NORTH"));	
	}
	
	@Test
	void testCEmpty(CapturedOutput output) {
		springApp.run("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_empty.txt");
		assertTrue(output.getErr().contains("Failed"));	
	}
	
	
}
