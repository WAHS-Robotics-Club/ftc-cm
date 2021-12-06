package org.firstinspires.ftc.teamcode.Objects;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Tool.Toggle;

public class Misc {
    //public Servo foundationGrabber;
    Toggle toggleFoundationGrabber;
    //public Servo capstoneDropper;
    Toggle toggleSpinnerServo;
    CRServoImplEx carouselServo;

    public static Misc initMiscellaneous(HardwareMap hardwareMap){
        Misc misc = new Misc();
        //misc.foundationGrabber = hardwareMap.servo.get("foundationServo");
        misc.toggleFoundationGrabber = new Toggle();
        //misc.capstoneDropper = hardwareMap.servo.get("capstoneDropper");
        misc.toggleSpinnerServo = new Toggle();
        misc.carouselServo = (CRServoImplEx) hardwareMap.crservo.get("spinnerServo");

        return misc;
    }

    public void manualTogglePosition(Gamepad gamepad){
        if(gamepad.b){
            toggleSpinnerServo.toggle();
        }
    }

    public void runCarouselServo(){
        if(toggleSpinnerServo.isToggled()){
            carouselServo.setPower(1);
        }else{
            carouselServo.setPower(0);
        }
    }


}
