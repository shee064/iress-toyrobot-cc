package com.si.iress.toyrobot.trc.component;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.DirectionEnum;
import com.si.iress.toyrobot.trc.util.MessageConstants;

class ReportCommandComponentTest {

	private ToyRobot robot;
	
	@BeforeEach
	void setUp() {
		robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH, MessageConstants.TBL_WIDTH));
		robot.setPosition(new Position(0,0));
		robot.setDirection(DirectionEnum.WEST);
	}
	
	@Test
	void whenCommandIsReport_thenPrintThePositionOftheRobot() {
		ReportCommandComponent rptCmd = new ReportCommandComponent();
		rptCmd.execute(robot);
		assertEquals("0,0,WEST", robot.getCurrentPosition());
	}

}
