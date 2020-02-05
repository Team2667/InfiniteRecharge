package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheel;

public class CallibrateColorWheel extends CommandBase {
    private ColorWheel colorWheel;
    private Color currentColor;
    public CallibrateColorWheel(ColorWheel colorWheel) {
        this.colorWheel = colorWheel;
        this.setSubsystem("colorWheel");
        addRequirements(colorWheel);
    }
    public void initialize() {
    
        
    }
    @Override
    public boolean isFinished() {
        currentColor = colorWheel.getColor();
        if (currentColor == ColorWheel.kRedTarget || currentColor == ColorWheel.kBlueTarget) {
            return true;
        }
        else {
            return false;
        }
    }
    public void end(boolean isInterupted) {
        this.colorWheel.wheelStop();
    }
    public void execute() {
        this.colorWheel.wheelStart(1);
    }
}