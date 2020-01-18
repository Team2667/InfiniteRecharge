package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class ColorWheel extends ExampleSubsystem {
    TalonSRX wheelSpinner;
    public ColorWheel() {
        wheelSpinner = new TalonSRX(Constants.CW_MOTOR);
    }
    public void wheelStart (double speed) {
        wheelSpinner.set(ControlMode.PercentOutput, speed);
    }
    public void wheelStop () {
        wheelSpinner.set(ControlMode.PercentOutput, 0);
   }
   
}