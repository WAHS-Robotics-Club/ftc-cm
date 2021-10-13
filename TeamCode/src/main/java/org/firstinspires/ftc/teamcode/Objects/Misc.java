package org.firstinspires.ftc.team9202hme.Objects;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.team9202hme.Tool.Toggle;

public class Misc {
    public Servo foundationGrabber;
    Toggle toggleFoundationGrabber;
    public Servo capstoneDropper;
    Toggle toggleCapstoneDropper;

    public static Misc initMiscellaneous(HardwareMap hardwareMap){
        Misc misc = new Misc();
        misc.foundationGrabber = hardwareMap.servo.get("foundationServo");
        misc.toggleFoundationGrabber = new Toggle();
        misc.capstoneDropper = hardwareMap.servo.get("capstoneDropper");
        misc.toggleCapstoneDropper = new Toggle();

        return misc;
    }

    public void checkTogglePosition(Gamepad gamepad){
        if(gamepad.a){
            toggleFoundationGrabber.toggle();
        }
        if(gamepad.b){
            toggleCapstoneDropper.toggle();
        }
    }

    public void useMiscLoop(){
        useFoundationGrabber();
        useCapstoneDropper();
    }

    public void useFoundationGrabber(){
        if(toggleFoundationGrabber.isToggled()){
            foundationGrabber.setPosition(0);
        }else{
            foundationGrabber.setPosition(180);
        }
    }

    public void useCapstoneDropper(){
        if(toggleCapstoneDropper.isToggled()){
            capstoneDropper.setPosition(0);
        }else{
            capstoneDropper.setPosition(180);
        }
    }


}
