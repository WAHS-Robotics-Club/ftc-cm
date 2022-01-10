package org.firstinspires.ftc.teamcode.Objects;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Tool.Toggle;

public class Misc {
    Toggle toggleCarouselServo;
    CRServoImplEx carouselServo;

    public static Misc initMiscellaneous(HardwareMap hardwareMap){
        Misc misc = new Misc();
        misc.toggleCarouselServo = new Toggle();
        misc.carouselServo = (CRServoImplEx) hardwareMap.crservo.get("spinnerServo");

        return misc;
    }

    public void toggleCarouselManual(Gamepad gamepad){
        if(gamepad.b){
            toggleCarouselServo.toggle();
        }
    }

    public void toggleCarouselAuto() throws InterruptedException{
        toggleCarouselServo.toggle();
        Thread.sleep(50);
        runCarouselServo();
    }

    public void runCarouselServo(){
        if(toggleCarouselServo.isToggled()){
            carouselServo.setPower(1);
        }else{
            carouselServo.setPower(0);
        }
    }


}
