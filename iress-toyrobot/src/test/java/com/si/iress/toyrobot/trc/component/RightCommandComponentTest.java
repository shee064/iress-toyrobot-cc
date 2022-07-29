package com.si.iress.toyrobot.trc.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.DirectionEnum;
import com.si.iress.toyrobot.trc.util.MessageConstants;

class RightCommandComponentTest {

	private ToyRobot robot;
	
	@BeforeEach
	void setUp() {
		robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH, MessageConstants.TBL_WIDTH));
		robot.setPosition(new Position(0,0));
	}
	
	@Test
	void whenDirectionIsWest_thenRightIsNorth() {
		robot.setDirection(DirectionEnum.WEST);
		RightCommandComponent rtCmd = new RightCommandComponent();
		rtCmd.execute(robot);
		assertEquals(DirectionEnum.NORTH, robot.getDirection());
	}

	@Test
	void whenDirectionIsEast_thenLeftIsSouth() {
		robot.setDirection(DirectionEnum.EAST);
		RightCommandComponent rtCmd = new RightCommandComponent();
		rtCmd.execute(robot);
		assertEquals(DirectionEnum.SOUTH, robot.getDirection());
	}
	

	@Test
	void whenDirectionIsSouth_thenLeftIsWest() {
		robot.setDirection(DirectionEnum.SOUTH);
		RightCommandComponent rtCmd = new RightCommandComponent();
		rtCmd.execute(robot);
		assertEquals(DirectionEnum.WEST, robot.getDirection());
	}
	
	@Test
	void whenDirectionIsNorthh_thenLeftIsEst() {
		robot.setDirection(DirectionEnum.NORTH);
		RightCommandComponent rtCmd = new RightCommandComponent();
		rtCmd.execute(robot);
		assertEquals(DirectionEnum.EAST, robot.getDirection());
	}

}
