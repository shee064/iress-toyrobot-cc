package com.si.iress.toyrobot.trc.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;

class CommandValidatorTest {
	
	private ToyRobot robot;
	private List<String> cmdlist = new ArrayList<String>();
	
	@BeforeEach
	void setUp() {
		robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH, MessageConstants.TBL_WIDTH));
		robot.setPosition(new Position(0,0));
		robot.setDirection(DirectionEnum.WEST);
		cmdlist.add("PLACE 3,2,FORWARD");
		cmdlist.add("PLACE 1,0,EAST");
		cmdlist.add("LEFT");
		cmdlist.add("MOVE");
	}
	@Test
	void testTheValidityOftheCommand() {
		assertFalse(CommandValidator.validCommand("PLACE", robot.getTableArea()));
		assertTrue(CommandValidator.validCommand("PLACE 3,3,SOUTH", robot.getTableArea()));
		assertTrue(CommandValidator.validCommand("MOVE", robot.getTableArea()));
		assertFalse(CommandValidator.validCommand("PLACE 6,8,SOUTH", robot.getTableArea()));
		assertTrue(CommandValidator.validCommand("LEFT", robot.getTableArea()));
		assertTrue(CommandValidator.validCommand("RIGHT", robot.getTableArea()));
		assertTrue(CommandValidator.validCommand("REPORT", robot.getTableArea()));
	}
	
	@Test
	void whenPlaceCommandIsNotFirst_thenRemoveFromList() {
		cmdlist = CommandValidator.getValidCommandList(cmdlist);
		assertFalse(cmdlist.contains("FORWARD"));
		assertEquals(3,cmdlist.size());
	}

	@Test
	void whenPositionIsNotWithinTableRange_thenReturnFalse() {
		assertFalse(CommandValidator.validateIfWithinTableRange(robot.getTableArea(), 6,7));
		assertTrue(CommandValidator.validateIfWithinTableRange(robot.getTableArea(), 2,5));
		assertFalse(CommandValidator.validateIfWithinTableRange(robot.getTableArea(), -4,4));
		assertTrue(CommandValidator.validateIfWithinTableRange(robot.getTableArea(), 2,1));
	}
	
	@Test
	void whenDirectionIsNotValid_returnFalse() {
		assertFalse(CommandValidator.validateDirection("ABOVE"));
		assertTrue(CommandValidator.validateDirection("WEST"));
		assertTrue(CommandValidator.validateDirection("EAST"));
		assertFalse(CommandValidator.validateDirection("BELOW"));
		assertTrue(CommandValidator.validateDirection("SOUTH"));
		assertTrue(CommandValidator.validateDirection("NORTH"));
	}
}
