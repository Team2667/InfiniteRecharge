package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class IntakeRotary extends ExampleSubsystem {
    private TalonSRX rotarySpinner;
    public IntakeRotary() {
        rotarySpinner = new TalonSRX(Constants.IR_MOTOR);
    }
    public void rotaryStart (double speed) {
        rotarySpinner.set(ControlMode.PercentOutput, speed);
    }
    public void rotaryStop () {
        rotarySpinner.set(ControlMode.PercentOutput, 0);
   }
   
}