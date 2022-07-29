package com.si.iress.toyrobot.trc.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;

class CommandInitializerTest {

	private ToyRobot robot;
	
	@BeforeEach
	void setUp() {
		robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH, MessageConstants.TBL_WIDTH));
		robot.setPosition(new Position(0,0));
	}
	
	@Test
	void whenCommandIsNotValid_theItShouldBeIgnored() {
		CommandInitializer commandInit = new CommandInitializer("src/test/java/com/si/iress/toyrobot/iresstoyrobot/test_jumpcmd.txt", robot.getTableArea());
		assertFalse(commandInit.getValidCommands().contains("JUMP"));
	}

}
