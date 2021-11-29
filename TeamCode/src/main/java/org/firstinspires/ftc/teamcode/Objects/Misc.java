package org.firstinspires.ftc.teamcode.Objects;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Tool.Toggle;

public class Misc {
    //public Servo foundationGrabber;
    Toggle toggleFoundationGrabber;
    //public Servo capstoneDropper;
    Toggle toggleCapstoneDropper;

    public static Misc initMiscellaneous(HardwareMap hardwareMap){
        Misc misc = new Misc();
        //misc.foundationGrabber = hardwareMap.servo.get("foundationServo");
        misc.toggleFoundationGrabber = new Toggle();
        //misc.capstoneDropper = hardwareMap.servo.get("capstoneDropper");
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



}
