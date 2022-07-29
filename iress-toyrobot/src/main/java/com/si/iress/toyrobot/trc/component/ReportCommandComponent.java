package com.si.iress.toyrobot.trc.component;

import com.si.iress.toyrobot.trc.model.ToyRobot;
/**
 * ReportCommandComponent - provides logic for REPORT command
 * @author sheenai
 *
 */
public class ReportCommandComponent implements CommandComponent{

	@Override
	public void execute(ToyRobot robot) {
		robot.setCurrentPosition(robot.getPosition().getxPos()+","+
					robot.getPosition().getyPos()+","+robot.getDirection().getValue());
		System.out.println("Output: " +robot.getCurrentPosition());		
	}

}