package com.si.iress.toyrobot.trc;

import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.si.iress.toyrobot.trc.model.TableArea;
import com.si.iress.toyrobot.trc.model.ToyRobot;
import com.si.iress.toyrobot.trc.util.CommandInitializer;
import com.si.iress.toyrobot.trc.util.CommandUtil;
import com.si.iress.toyrobot.trc.util.MessageConstants;
/**
 * IressToyRobotApplication -  This is the entry point of program execution
 * @author sheenai
 *
 */
@SpringBootApplication
public class IressToyRobotApplication implements CommandLineRunner{

	private static Logger LOGGER = LogManager.getLogger(IressToyRobotApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info(MessageConstants.APP_START);
		SpringApplication app = new SpringApplication(IressToyRobotApplication.class);
		app.setBannerMode(Mode.OFF);
		app.setLogStartupInfo(false);
		app.run(args);
		LOGGER.info(MessageConstants.APP_END);
	}

	@Override
	public void run(String... args) throws Exception {
		if(args.length > 0) {
			ToyRobot robot = new ToyRobot(new TableArea(MessageConstants.TBL_LENGTH,MessageConstants.TBL_WIDTH));
			CommandInitializer commandInit = new CommandInitializer(args[0], robot.getTableArea());			
			Stream<String> commands = (Stream<String>) commandInit.getValidStringCommands();
			
			if(commands != null) {
				CommandUtil.executeCommandToRobot(robot, commands);
			}else {
				LOGGER.info(MessageConstants.APP_EXT);
			}
			
		}else {
			LOGGER.info(MessageConstants.APP_EXT);
		}
	}

}
