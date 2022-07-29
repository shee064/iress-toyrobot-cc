package com.si.iress.toyrobot.trc.component;

import com.si.iress.toyrobot.trc.model.Position;
import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.CommandValidator;
import com.si.iress.toyrobot.trc.util.DirectionEnum;
/**
 * PlaceCommandComponent - provides logic for PLACE command
 * @author sheenai
 *
 */
public class PlaceCommandComponent implements CommandComponent{

	private int x;
	private int y;
	private String d;
	
	public PlaceCommandComponent (int x, int y, String d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public void execute(ToyRobot robot) {
		if(CommandValidator.validateIfWithinTableRange(robot.getTableArea(), getX(), getY()) && 
				DirectionEnum.getDerictionList().contains(getD())) {
			Position position = new Position(getX(), getY());
			DirectionEnum direction = DirectionEnum.valueOf(getD());
			robot.setPosition(position);
			robot.setDirection(direction);
			robot.setCurrentPosition(robot.getPosition().getxPos()+","+
					robot.getPosition().getyPos()+","+robot.getDirection().getValue());
		}
	}
	
// getters and setters
	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}


	public String getD() {
		return d;
	}


}
