package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "Holonomic_Drew")
public class Holonomic_Drew extends OpMode {
    DcMotor fl, bl, fr, br;
    @Override
    public void init() {
        fl = hardwareMap.dcMotor.get("fl");
        bl = hardwareMap.dcMotor.get("bl");
        fr = hardwareMap.dcMotor.get("fr");
        br = hardwareMap.dcMotor.get("br");
    }

    @Override
    public void loop() {

        if (Math.abs(gamepad1.left_stick_y) > .01 || Math.abs(gamepad1.left_stick_x) > .01) {

        }
    }
}