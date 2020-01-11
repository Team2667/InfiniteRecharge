package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    CANSparkMax shLeft, shRight;
    public Shooter() {
        shLeft = new CANSparkMax(Constants.SH_LEFT, MotorType.kBrushless);
       shLeft.setInverted(true);
        shRight = new CANSparkMax(Constants.SH_RIGHT, MotorType.kBrushless);
    }
    public void start (double speed) {
        shLeft.set(speed);
        shRight.set(speed);
    }
    public void stop() {
        shLeft.set(0);
        shRight.set(0);
    }
    public void shootIntelegent() {
        shRight.getEncoder();

    }
}