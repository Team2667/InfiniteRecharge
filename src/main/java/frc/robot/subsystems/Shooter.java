package frc.robot.subsystems;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    CANSparkMax shLeft, shRight;
    
    CANPIDController  leftPidController;
    CANPIDController  rightPidController;
                        // A good resource for tuning pid:
                        // https://frc-pdr.readthedocs.io/en/latest/control/pid_control.html
                        // First determine p leaving i and d set to 0.
    private   double  p;
    private  double  i = 0.0; 
    private double d = 0.0; 


    
    public Shooter() {
        shLeft = new CANSparkMax(Constants.SH_LEFT, MotorType.kBrushless);
       shLeft.setInverted(true);
        shRight = new CANSparkMax(Constants.SH_RIGHT, MotorType.kBrushless);
    
        leftPidController = shLeft.getPIDController();
        rightPidController = shRight.getPIDController();
    
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

    public void startAtSpeed(double rpm){
        // set output range for left and right controllers
        // set pid values for left and right controllers
        // set reference on controller
       
        
    }
}