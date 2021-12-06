package org.firstinspires.ftc.teamcode.Objects;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Tool.Toggle;

public class Misc {
    //public Servo foundationGrabber;
    Toggle toggleFoundationGrabber;
    //public Servo capstoneDropper;
    Toggle toggleSpinnerServo;
    public Servo spinnerServo;

    public static Misc initMiscellaneous(HardwareMap hardwareMap){
        Misc misc = new Misc();
        //misc.foundationGrabber = hardwareMap.servo.get("foundationServo");
        misc.toggleFoundationGrabber = new Toggle();
        //misc.capstoneDropper = hardwareMap.servo.get("capstoneDropper");
        misc.toggleSpinnerServo = new Toggle();
        misc.spinnerServo = hardwareMap.servo.get("spinnerServo");

        return misc;
    }

    public void manualTogglePosition(Gamepad gamepad){
        if(gamepad.a){
            toggleFoundationGrabber.toggle();
        }
        if(gamepad.b){
            toggleSpinnerServo.toggle();
        }
    }

    public void checkSpinnerToggle(){
        spinnerServo.
    }



}
