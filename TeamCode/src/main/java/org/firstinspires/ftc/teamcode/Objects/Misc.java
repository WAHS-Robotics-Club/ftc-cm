package org.firstinspires.ftc.teamcode.Objects;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Tool.Toggle;

public class Misc {
    Toggle toggleCarouselPower;
    Toggle toggleCarouselDirection;
    CRServoImplEx carouselServo;

    public static Misc initMiscellaneous(HardwareMap hardwareMap){
        Misc misc = new Misc();
        misc.toggleCarouselPower = new Toggle();
        misc.toggleCarouselDirection = new Toggle();
        misc.carouselServo = (CRServoImplEx) hardwareMap.crservo.get("spinnerServo");

        return misc;
    }

    public void toggleCarouselPowerManual(Gamepad gamepad){
        if(gamepad.b){
            toggleCarouselPower.toggle();
        }
    }

    public void toggleCarouselPowerAuto() throws InterruptedException{
        toggleCarouselPower.toggle();
        Thread.sleep(50);
        runCarouselServo();
    }

    public void toggleCarouselDirectionManual(Gamepad gamepad){
        if(gamepad.a){
            toggleCarouselDirection.toggle();
        }
    }

    public void toggleCarouselDirectionAuto() throws InterruptedException{
        toggleCarouselDirection.toggle();
        Thread.sleep(50);
        runCarouselServo();
    }

    public void runCarouselServo(){
        if(toggleCarouselPower.isToggled()){
            if(toggleCarouselDirection.isToggled()){
                carouselServo.setPower(-1);
            }else{
                carouselServo.setPower(1);
            }
        }else{
            carouselServo.setPower(0);
        }
    }


}
