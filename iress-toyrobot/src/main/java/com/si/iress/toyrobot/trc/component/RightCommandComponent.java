package com.si.iress.toyrobot.trc.component;

import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.DirectionEnum;
/**
 * RightCommandComponent - provides logic for RIGHT command
 * @author sheenai
 *
 */
public class RightCommandComponent implements CommandComponent{

	private DirectionEnum direction;

	@Override
	public void execute(ToyRobot robot) {
		switch(robot.getDirection()) {
		case NORTH:
			direction=DirectionEnum.EAST;
			break;
		case EAST:
			direction=DirectionEnum.SOUTH;
			break;
		case WEST:
			direction=DirectionEnum.NORTH;
			break;
		case SOUTH:
			direction=DirectionEnum.WEST;
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

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}
}
