package com.si.iress.toyrobot.trc.util;

import java.util.regex.Matcher;
import java.util.stream.Stream;

import com.si.iress.toyrobot.trc.component.CommandComponent;
import com.si.iress.toyrobot.trc.component.LeftCommandComponent;
import com.si.iress.toyrobot.trc.component.MoveCommandComponent;
import com.si.iress.toyrobot.trc.component.PlaceCommandComponent;
import com.si.iress.toyrobot.trc.component.ReportCommandComponent;
import com.si.iress.toyrobot.trc.component.RightCommandComponent;
import com.si.iress.toyrobot.trc.model.ToyRobot;
/**
 * CommandUtil provides utility in command mapping and execution
 * @author sheenai
 *
 */
public class CommandUtil {

	/**
	 * This method executes the command received according to command type
	 * @param command
	 * @param robot
	 */
	public static void executeCommand(CommandComponent command, ToyRobot robot){
		if (command instanceof PlaceCommandComponent) {
				command.execute(robot);
		}else if (command instanceof MoveCommandComponent) {
			command.execute(robot);
		}else if (command instanceof LeftCommandComponent) {
			command.execute(robot);
		}else if (command instanceof RightCommandComponent) {
			command.execute(robot);
		}else if(command instanceof ReportCommandComponent) {
			command.execute(robot);
		}
	}
	/**
	 * This method matches the command and returns the correct component accordingly
	 * @param command
	 * @return
	 */
	public static CommandComponent getCommand(String command) {
		Matcher placeCommandMatcher = CommandValidator.getPlacePattern().matcher(command);
		if(placeCommandMatcher.matches()) {
			return new PlaceCommandComponent(Integer.parseInt(placeCommandMatcher.group(1)), Integer.parseInt(placeCommandMatcher.group(2)), placeCommandMatcher.group(3).toString());
		}else if (command.equals(String.valueOf(CommandEnum.MOVE))) {
			return new MoveCommandComponent();
		}else if (command.equals(String.valueOf(CommandEnum.LEFT))) {
			return new LeftCommandComponent();
		}else if (command.equals(String.valueOf(CommandEnum.RIGHT))) {
			return new RightCommandComponent();
		}else if (command.equals(String.valueOf(CommandEnum.REPORT))) {
			return new ReportCommandComponent();
		}else {
			System.out.println(command + " is not a valid command and will be ignored.");
		}
		
		return null;
	}
	/**
	 * This method pass the stream of commands to robot for execution
	 * @param robot
	 * @param inputCommand
	 */
	public static void executeCommandToRobot(ToyRobot robot, Stream<String> inputCommand) {
		inputCommand.map(CommandUtil::getCommand).forEach(robot::passCommand);
	}
}
