package com.si.iress.toyrobot.trc.component;

import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.CommandValidator;
/**
 * MoveCommandComponent - provides logic for MOVE command
 * @author sheenai
 *
 */
public class MoveCommandComponent implements CommandComponent{

	private final int numberOfUnit = 1;
	private Position position = new Position(0,0);
	
	@Override
	public void execute(ToyRobot robot) {
		int newPosition = 0;
		switch(robot.getDirection()) {
			case NORTH:
				newPosition = robot.getPosition().getyPos() + numberOfUnit;
				position.setxPos(robot.getPosition().getxPos());
				position.setyPos(CommandValidator.validateIfWithinTableRange(robot.getTableArea(), newPosition, position.getxPos())?
						newPosition : robot.getPosition().getyPos());				
				break;
			case EAST:
				newPosition = robot.getPosition().getxPos() + numberOfUnit;
				position.setyPos(robot.getPosition().getyPos());
				position.setxPos(CommandValidator.validateIfWithinTableRange(robot.getTableArea(), position.getxPos(),newPosition)?
						newPosition : robot.getPosition().getxPos());	
				break;
			case WEST:
				newPosition = robot.getPosition().getxPos() - numberOfUnit;
				position.setyPos(robot.getPosition().getyPos());
				position.setxPos(CommandValidator.validateIfWithinTableRange(robot.getTableArea(), position.getxPos(),newPosition)?
						newPosition : robot.getPosition().getxPos());
				break;
			case SOUTH:
				newPosition = robot.getPosition().getyPos() - numberOfUnit;
				position.setxPos(robot.getPosition().getxPos());
				position.setyPos(CommandValidator.validateIfWithinTableRange(robot.getTableArea(), newPosition, position.getxPos())?
						newPosition : robot.getPosition().getyPos());
				break;
			default:
				break;
			
		}
				
		robot.setPosition(getPosition());
		robot.setCurrentPosition(robot.getPosition().getxPos()+","+
		robot.getPosition().getyPos()+","+robot.getDirection().getValue());
		
	}
	public int getNumberOfUnit() {
		return numberOfUnit;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
}
