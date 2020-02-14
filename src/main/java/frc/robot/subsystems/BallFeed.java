package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallFeed extends SubsystemBase {
    private TalonSRX ballSpinner;
    public BallFeed() {
        ballSpinner = new TalonSRX(Constants.BF_CAN);
    }
    public void ballStart (double speed) {
        ballSpinner.set(ControlMode.PercentOutput, speed);
    }
    public void ballStop() {
        ballSpinner.set(ControlMode.PercentOutput, 0);
    }
    public void ballToggle(double speed) {
        if (ballSpinner.getMotorOutputPercent() == 0) {
            ballSpinner.set(ControlMode.PercentOutput, speed);
        }
        else {
           ballSpinner.set(ControlMode.PercentOutput, 0);
        }
    }
}