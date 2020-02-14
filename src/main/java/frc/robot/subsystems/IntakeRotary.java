package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeRotary extends SubsystemBase {
    private TalonSRX rotarySpinner;
    public IntakeRotary() {
        rotarySpinner = new TalonSRX(Constants.IR_MOTOR);
    }
    public void rotaryStart (double speed) {
        rotarySpinner.set(ControlMode.PercentOutput, -speed);
    }
    public void rotaryStop() {
        rotarySpinner.set(ControlMode.PercentOutput, 0);
    }
    public void rotaryToggle(double speed) {
        if (rotarySpinner.getMotorOutputPercent() == 0) {
            rotarySpinner.set(ControlMode.PercentOutput, -speed);
        }
        else {
            rotarySpinner.set(ControlMode.PercentOutput, 0);;
        }
    }
}