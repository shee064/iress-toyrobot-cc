package com.si.iress.toyrobot.trc.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.si.iress.toyrobot.trc.component.CommandComponent;
import com.si.iress.toyrobot.trc.component.LeftCommandComponent;
import com.si.iress.toyrobot.trc.component.MoveCommandComponent;
import com.si.iress.toyrobot.trc.component.PlaceCommandComponent;
import com.si.iress.toyrobot.trc.component.ReportCommandComponent;
import com.si.iress.toyrobot.trc.component.RightCommandComponent;
import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;

class CommandUtilTest {

	private ToyRobot robot;
	private CommandComponent cmd;
	private List<String> cmdlist = new ArrayList<String>();
	
	@BeforeEach
	void setUp() {
		robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH, MessageConstants.TBL_WIDTH));
		robot.setPosition(new Position(0,0));
		cmdlist.add("PLACE 3,2,FORWARD");
		cmdlist.add("PLACE 1,0,EAST");
		cmdlist.add("LEFT");
		cmdlist.add("MOVE");
	}
	
	@Test
	void commandShouldBeProperlyExecuted() {
		CommandUtil.executeCommand(new PlaceCommandComponent(0, 0, "SOUTH"), robot);
		assertEquals("0,0,SOUTH", robot.getCurrentPosition());
		
		CommandUtil.executeCommand(new MoveCommandComponent(), robot);
		assertEquals("0,0,SOUTH", robot.getCurrentPosition());
		
		CommandUtil.executeCommand(new LeftCommandComponent(), robot);
		assertEquals("0,0,EAST", robot.getCurrentPosition());
		
		CommandUtil.executeCommand(new RightCommandComponent(), robot);
		assertEquals("0,0,SOUTH", robot.getCurrentPosition());
		
	}	
	
	@Test
	void rightCommandShouldBeReturned() {
		cmd = CommandUtil.getCommand("PLACE 1,1,NORTH");
		assertTrue(cmd instanceof PlaceCommandComponent);
		
		cmd = CommandUtil.getCommand("MOVE");
		assertTrue(cmd instanceof MoveCommandComponent);
		
		cmd = CommandUtil.getCommand("LEFT");
		assertTrue(cmd instanceof LeftCommandComponent);

		cmd = CommandUtil.getCommand("RIGHT");
		assertTrue(cmd instanceof RightCommandComponent);
		
		cmd = CommandUtil.getCommand("REPORT");
		assertTrue(cmd instanceof ReportCommandComponent);
		
	}
	
	@Test
	void whenStreamOfCommandHasInvalidCommand_thenIgnoreInvalidCommand() {
		CommandUtil.executeCommandToRobot(robot, cmdlist.stream());
		assertEquals("1,1,NORTH",robot.getCurrentPosition());
	}

	
}
