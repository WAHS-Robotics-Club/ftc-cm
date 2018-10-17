package org.firstinspires.ftc.teamcode.Zach.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name = "Holonomic_Zach")
public class Holonomic_Zach extends OpMode {
    DcMotor fr, fl, br, bl;

    @Override
    public void init() {
        fr = hardwareMap.dcMotor.get("fr");
        fl = hardwareMap.dcMotor.get("fl");
        br = hardwareMap.dcMotor.get("br");
        bl = hardwareMap.dcMotor.get("bl");

    }

    @Override
    public void loop() {
        

        if (Math.abs(gamepad1.left_stick_y) > 0.1 || gamepad1.left_stick_x > .01) {
        }
    }
}
