package com.si.iress.toyrobot.trc.model;

import com.si.iress.toyrobot.trc.component.CommandComponent;
import com.si.iress.toyrobot.trc.util.CommandUtil;
import com.si.iress.toyrobot.trc.util.DirectionEnum;

public class ToyRobot {

	private Position position;
	private TableArea tableArea;
	DirectionEnum direction;
	private String currentPosition;
	
	public ToyRobot (TableArea tableArea){
		this.tableArea = tableArea;
		
	}                                      

	public void passCommand(CommandComponent command){
		CommandUtil.executeCommand(command,this);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public DirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}

	public String getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}

	public TableArea getTableArea() {
		return tableArea;
	}
	
	

}
