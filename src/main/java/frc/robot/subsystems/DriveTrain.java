package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.GenericHID;

public class DriveTrain extends SubsystemBase {
    private DifferentialDrive drivetrain;
    public DriveTrain() {
        CANSparkMax left1, left2, left3, right1, right2, right3;

        right1 = new CANSparkMax(Constants.DT_LEFT1, MotorType.kBrushless);
        right2 = new CANSparkMax(Constants.DT_LEFT2, MotorType.kBrushless);
        right3 = new CANSparkMax(Constants.DT_LEFT3, MotorType.kBrushless);
        left1 = new CANSparkMax(Constants.DT_RIGHT1, MotorType.kBrushless);
        left2 = new CANSparkMax(Constants.DT_RIGHT2, MotorType.kBrushless);
        left3 = new CANSparkMax(Constants.DT_RIGHT3, MotorType.kBrushless);
        left2.follow(left1);
        left3.follow(left1);
        right2.follow(right1);
        right3.follow(right1);
        left1.setInverted(true);
        right1.setInverted(false);
        drivetrain = new DifferentialDrive(left1, right1);
    }

    public void arcadeDrive(GenericHID joy) {
        drivetrain.arcadeDrive(-joy.getX(), joy.getY());
    }
    public void stop() {
        drivetrain.stopMotor();
    }
}