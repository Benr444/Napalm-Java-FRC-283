package org.usfirst.frc.team283.napalm;

/*
 * This class was created to shorten some math in our programs to create smoother deadzones everywhere
 * For 90% of cases, we'll just do rescale([deadzone e.g. (0.1)], 1, 0, 1, speed)
 * Where speed is, for example, the magnitude of your joystick and deadzone is your deadzone(e.g. 0.1)
 */
public class Rescaler
{
	
	public static double rescale(double lowero, double uppero, double lowern, double uppern, double value)
	{
		/* lowero = Lower end of Original Scale
		    * uppero = Upper end of Original Scale
		    * lowern = Lower end of New Scale
		    * uppern = Upper end of New Scale
		    * value = the value on the orginal scale, to be rescaled
		    

		    
		    * This is essentially a proportion.
		    * (Value - lowero/oldscale) = (NewValue/Newscale)
		    * Then add the lowern
		     The scales should be difference of the upper and lower;
		     e.g. scale of 2-5 becomes a scale from 0-3 because 5 minus 2 = 3.
		      After proportioning, you have to add the lower value of the new scale back in order to go from 0-3 to 2-5
		    
		     If this is still unclear, work it out on a piece of paper
		    

		    
		     HOW TO USE WITH A DEADZONE
		     Rescale((c_deadzone, 1.0, 0.0, 1.0, magnitude));
		     This works with a negative and positive mag
		    */

		boolean neg = false;
		double rescaledValue = 0;	//Rescaled Value = number to be returned
		if (value < 0)
		{
				neg = true;
				value *= -1;
		}
		double oldscale = uppero - lowero;
		double newscale = uppern - lowern;

		rescaledValue = value - lowero;
		rescaledValue /= oldscale;
		rescaledValue *= newscale;
		rescaledValue += lowern;

		if (rescaledValue < 0)
		{
			rescaledValue = 0;
		}
		if (neg == true)
		{
			rescaledValue *= -1;
		}
		return rescaledValue;
	}
}