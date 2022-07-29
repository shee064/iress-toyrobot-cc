package com.si.iress.toyrobot.trc.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.DirectionEnum;
import com.si.iress.toyrobot.trc.util.MessageConstants;

class MoveCommandComponentTest {


	private ToyRobot robot;
	
	@BeforeEach
	void setUp() {
		robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH, MessageConstants.TBL_WIDTH));
		robot.setPosition(new Position(0,0));
	}
	
	@Test
	void testWhenDirectionIsNorth_thenPositionYIs1() {
		MoveCommandComponent moveComponent = new MoveCommandComponent();
		robot.setDirection(DirectionEnum.NORTH);
		moveComponent.execute(robot);
		assertEquals(robot.getPosition().getyPos(),1);
	}
	
	@Test
	void testWhenDirectionIsEast_thenPositionXIs1() {
		MoveCommandComponent moveComponent = new MoveCommandComponent();
		robot.setDirection(DirectionEnum.EAST);
		moveComponent.execute(robot);
		assertEquals(robot.getPosition().getxPos(),1);
	}
	
	@Test
	void testWhenDirectionIsWest_thenPositionXIs0() {
		MoveCommandComponent moveComponent = new MoveCommandComponent();
		robot.setDirection(DirectionEnum.WEST);
		moveComponent.execute(robot);
		assertEquals(robot.getPosition().getxPos(),0);
	}
	
	@Test
	void testWhenDirectionIsSout_thenPositionXIs0() {
		MoveCommandComponent moveComponent = new MoveCommandComponent();
		robot.setDirection(DirectionEnum.SOUTH);
		moveComponent.execute(robot);
		assertEquals(robot.getPosition().getxPos(),0);
	}

}
