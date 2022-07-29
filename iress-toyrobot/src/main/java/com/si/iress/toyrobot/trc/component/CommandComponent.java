package com.si.iress.toyrobot.trc.component;

import org.springframework.stereotype.Component;

import com.si.iress.toyrobot.trc.model.ToyRobot;
/**
 * CommandComponent is the component being called by the implementing classes to perform the command
 * @author sheenai
 *
 */
@Component
public interface CommandComponent {

	void execute(ToyRobot robot);
}
