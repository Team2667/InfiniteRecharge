package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeExtender extends SubsystemBase {
    private DoubleSolenoid leftRam;
    private DoubleSolenoid rightRam;

    public IntakeExtender() {
        rightRam = new DoubleSolenoid(Constants.IE_CAN, Constants.INTK_CHNL_R, Constants.INTK_REVERSE_CHNL_R);
        leftRam = new DoubleSolenoid(Constants.IE_CAN, Constants.INTK_CHNL_L, Constants.INTK_REVERSE_CHNL_L);
    }

    public void toggleIntake() {
        if (rightRam.get() == Value.kForward) {
            rightRam.set(Value.kReverse);
            leftRam.set(Value.kReverse);

        }
        else {
            leftRam.set(Value.kForward);
            rightRam.set(Value.kForward);
        }

        
    }
}