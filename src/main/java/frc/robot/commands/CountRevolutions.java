package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.subsystems.ColorWheel;
import java.util.HashMap;
import java.util.Map;

public class CountRevolutions extends CommandBase {
    private ColorWheel colorWheel;
    private Map<Color, Color> nextColorMap = new HashMap<>();
    private int changes = 16;
    private int changeCount;
    private Color nextColor;
    public CountRevolutions(ColorWheel colorWheel) {
        this.colorWheel = colorWheel;
        this.setSubsystem("colorWheel");
        addRequirements(colorWheel);
        nextColorMap.put(ColorWheel.kBlueTarget, ColorWheel.kYellowTarget);

        nextColorMap.put(ColorWheel.kYellowTarget, ColorWheel.kRedTarget);

        nextColorMap.put(ColorWheel.kRedTarget, ColorWheel.kGreenTarget);

        nextColorMap.put(ColorWheel.kGreenTarget, ColorWheel.kBlueTarget);
    }

    @Override
    public void initialize() {
        nextColor = nextColorMap.get(colorWheel.getColor());
        changeCount = 0;
    }
    @Override
    public void execute() {
        var currentColor = colorWheel.getColor();
        colorWheel.wheelStart(1);

        if (nextColor == currentColor){
            changeCount += 1;
            nextColor = nextColorMap.get(currentColor);
        }
    }
    @Override
    public boolean isFinished() {
        if (changeCount == changes){
            return true;
        }
        else {
            return false;
        }
        
    }
    @Override
    public void end(boolean isInterrupted) {
        colorWheel.wheelStop();
    }

}
