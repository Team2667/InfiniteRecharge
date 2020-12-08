package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class Feeder extends ExampleSubsystem {
    private TalonSRX feederMotor;
    public Feeder() {
        feederMotor = new TalonSRX(Constants.F_CAN);
    }
    public void feederStart (double speed) {
        feederMotor.set(ControlMode.PercentOutput, -speed);
    }
    public void feederStop() {
        feederMotor.set(ControlMode.PercentOutput, 0);
    }
    public void feederToggle(double speed) {
        if (feederMotor.getMotorOutputPercent() == 0) {
            feederMotor.set(ControlMode.PercentOutput, speed);
        }
        else {
            feederMotor.set(ControlMode.PercentOutput, 0);
        }
    }

   
}