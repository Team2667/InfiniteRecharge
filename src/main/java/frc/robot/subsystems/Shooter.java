package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    CANSparkMax shooterLeft, shooterRight;
    public Shooter() {
        shooterLeft = new CANSparkMax(Constants.SH_LEFT, MotorType.kBrushless);
       shooterLeft.setInverted(true);
        shooterRight = new CANSparkMax(Constants.SH_RIGHT, MotorType.kBrushless);
    }
    public void start (double speed) {
        shooterLeft.set(-speed);
        shooterRight.set(-speed);
    }
    public void stop() {
        shooterLeft.set(0);
        shooterRight.set(0);
    }
    public void shootIntelegent() {
        shooterRight.getEncoder();
    }
    public void periodic() {
        SmartDashboard.putNumber("Left Shooter RPM", shooterLeft.getEncoder().getVelocity());
        SmartDashboard.putNumber("Right Shooter RPM", shooterRight.getEncoder().getVelocity());
    }
}