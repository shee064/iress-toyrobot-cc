package com.si.iress.toyrobot.trc.component;

import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.DirectionEnum;
/**
 * LeftCommandComponent - provides logic for left command
 * @author sheenai
 *
 */
public class LeftCommandComponent implements CommandComponent{

	private DirectionEnum direction; 
	
	@Override
	public void execute(ToyRobot robot) {
		switch(robot.getDirection()) {
		case NORTH:
			direction=DirectionEnum.WEST;
			break;
		case EAST:
			direction=DirectionEnum.NORTH;
			break;
		case WEST:
			direction=DirectionEnum.SOUTH;
			break;
		case SOUTH:
			direction=DirectionEnum.EAST;
			break;
		default:
			break;
			
		}
		robot.setDirection(getDirection());
		robot.setCurrentPosition(robot.getPosition().getxPos()+","+
		robot.getPosition().getyPos()+","+robot.getDirection().getValue());
	}
	public DirectionEnum getDirection() {
		return direction;
	}
	
}
