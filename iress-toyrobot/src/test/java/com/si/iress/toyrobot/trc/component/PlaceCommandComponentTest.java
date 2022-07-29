package com.si.iress.toyrobot.trc.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.CommandEnum;
import com.si.iress.toyrobot.trc.util.CommandInitializer;
import com.si.iress.toyrobot.trc.util.MessageConstants;

class PlaceCommandComponentTest {

	private ToyRobot robot;
	
	@BeforeEach
	void setUp() {
		robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH, MessageConstants.TBL_WIDTH));
		robot.setPosition(new Position(0,0));
	}
	
	@Test
	void whenPlaceCommandIsNotTheFirstCommand_thenIgnoreCommand() {
		CommandInitializer commandInit = new CommandInitializer("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_placenotfirstcmd.txt", robot.getTableArea());
		assertTrue(commandInit.getValidCommands().get(0).contains(CommandEnum.PLACE.getValue())); //test_placenotfirstcmd.txt has LEFT command as the first command on the list
	
	}
	
	@Test
	void whenPlaceCommandIsInProperFormat_thenItShouldExecute() {
		PlaceCommandComponent placeCommand = new PlaceCommandComponent(0,4,"NORTH");
		placeCommand.execute(robot);
		assertEquals(placeCommand.getX(), robot.getPosition().getxPos());
		assertEquals(placeCommand.getY(), robot.getPosition().getyPos());
		assertEquals(placeCommand.getD(), robot.getDirection().getValue());
		assertEquals("0,4,NORTH", robot.getCurrentPosition());
		
	}

}
