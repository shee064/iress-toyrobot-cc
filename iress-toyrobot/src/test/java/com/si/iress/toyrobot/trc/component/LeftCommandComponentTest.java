package com.si.iress.toyrobot.trc.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.DirectionEnum;
import com.si.iress.toyrobot.trc.util.MessageConstants;

class LeftCommandComponentTest {

	private ToyRobot robot;
	
	@BeforeEach
	void setUp() {
		robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH, MessageConstants.TBL_WIDTH));
		robot.setPosition(new Position(0,0));
	}

	@Test
	void whenDirectionIsWest_thenLeftIsSouth() {
		robot.setDirection(DirectionEnum.WEST);
		LeftCommandComponent leftCmd = new LeftCommandComponent();
		leftCmd.execute(robot);
		assertEquals(DirectionEnum.SOUTH, robot.getDirection());
	}

	@Test
	void whenDirectionIsEast_thenLeftIsNort() {
		robot.setDirection(DirectionEnum.EAST);
		LeftCommandComponent leftCmd = new LeftCommandComponent();
		leftCmd.execute(robot);
		assertEquals(DirectionEnum.NORTH, robot.getDirection());
	}
	

	@Test
	void whenDirectionIsSouth_thenLeftIsEast() {
		robot.setDirection(DirectionEnum.SOUTH);
		LeftCommandComponent leftCmd = new LeftCommandComponent();
		leftCmd.execute(robot);
		assertEquals(DirectionEnum.EAST, robot.getDirection());
	}
	
	@Test
	void whenDirectionIsNorthh_thenLeftIsWest() {
		robot.setDirection(DirectionEnum.NORTH);
		LeftCommandComponent leftCmd = new LeftCommandComponent();
		leftCmd.execute(robot);
		assertEquals(DirectionEnum.WEST, robot.getDirection());
	}
}
