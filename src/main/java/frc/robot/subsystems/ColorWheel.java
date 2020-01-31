package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorWheel extends SubsystemBase {

    public static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    public static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    public static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    public static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();


    TalonSRX wheelSpinner;

    public ColorWheel() {
        wheelSpinner = new TalonSRX(Constants.CW_MOTOR);
        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kGreenTarget);
        m_colorMatcher.addColorMatch(kRedTarget);
        m_colorMatcher.addColorMatch(kYellowTarget);  
    }

    public void wheelStart (double speed) {
        wheelSpinner.set(ControlMode.PercentOutput, speed);
    }

    public void wheelStop () {
        wheelSpinner.set(ControlMode.PercentOutput, 0);
   }

   public Color getColor() {
    return m_colorMatcher.matchClosestColor(m_colorSensor.getColor()).color;
   }
   @Override
   public void periodic() {
    String colorString;
    var color = getColor();
    if (color== kBlueTarget) {
      colorString = "Blue";
    } else if (color == kRedTarget) {
      colorString = "Red";
    } else if (color == kGreenTarget) {
      colorString = "Green";
    } else if (color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */

    SmartDashboard.putString("Detected Color", colorString);
    
   }
   
}