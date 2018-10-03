package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class LearnTest extends OpMode {
    DcMotor fr, fl, br, bl;
    Servo sl, sr;

    @Override
    public void init() {
        fr = hardwareMap.dcMotor.get("fr");
        fl = hardwareMap.dcMotor.get("fl");
        br = hardwareMap.dcMotor.get("br");
        bl = hardwareMap.dcMotor.get("bl");

        sl = hardwareMap.servo.get("sl");
        sr = hardwareMap.servo.get("sr");

        sl.setPosition(.18);

        }

    @Override
    public void loop() {

        if (gamepad1.left_stick_y > .01){
            
        }
        if (gamepad1.right_stick_y > .01) {

        }


    }
}
