package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Blue_red_OpMode extends OpMode {

    DcMotor fr, fl, br, bl;
    Servo S1, S2;
    Object x, y, z;
    @Override
    public void init() {
        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");

    }

    @Override
    public void loop() {
        x = gamepad1.left_stick_x;
        y = gamepad1.left_stick_y;

        if (gamepad1.left_stick_x > .01 || gamepad1.left_stick_y > .01){
            fl.getZeroPowerBehavior();

        }
    }
}
