package org.usfirst.frc.team283.napalm;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

public class DriveSubsystem
{
	//Constants
	private static final double DEADZONE = 0.1;
	private static final double SLOWSPEED = 0.5;
	//Variable States
	private static boolean storedState = false;
	
	Talon leftController;
	Talon rightController;
	Solenoid gearShift;
	
	public DriveSubsystem()
	{
		
		leftController = new Talon(Constants.LEFT_DRIVE_CONTROLLER_PORT);
		rightController = new Talon(Constants.RIGHT_DRIVE_CONTROLER_PORT);
		gearShift = new Solenoid(Constants.GEAR_SHIFT_SOLENOID_PORT);
	}
	
	public void periodic(float leftMagnitude, float rightMagnitude, boolean slowSpeed, boolean buttonState)
	{
		if(buttonState == true && storedState == false)
		{
			gearShift.set(!gearShift.get());
		}
		storedState = buttonState;
		if((leftMagnitude >= DEADZONE) || (leftMagnitude <= (-1 * DEADZONE)))
		{
			leftController.set(leftMagnitude);
		}
		if((rightMagnitude >= DEADZONE)||(rightMagnitude <= (-1 * DEADZONE)))
		{
			rightController.set(rightMagnitude);
		}
	}
	
	public void checkSlowmode()
	{
		
	}
	
	public void checkGearshit()
	{
		
	}
	
	
	
}
