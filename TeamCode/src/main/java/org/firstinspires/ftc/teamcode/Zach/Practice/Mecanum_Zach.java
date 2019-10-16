package org.firstinspires.ftc.teamcode.Zach.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "bruh")
public class Mecanum_Zach extends OpMode {
    DcMotor fr, fl, br, bl;
    //CRServo sl, sr;

    @Override
    public void init() {
        fr = hardwareMap.dcMotor.get("fr");
        fl = hardwareMap.dcMotor.get("fl");
        br = hardwareMap.dcMotor.get("br");
        bl = hardwareMap.dcMotor.get("bl");
       // sl = hardwareMap.crservo.get("sl");
       // sr = hardwareMap.crservo.get("sr");

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {

        float x = gamepad1.left_stick_x;
        float y = gamepad1.left_stick_y;
        float r = gamepad1.right_stick_x;
        if (Math.abs(gamepad1.left_stick_y) > 0.1 || gamepad1.left_stick_x > .01) {
            fl.setPower(-x + y - r);
            fr.setPower(-x - y - r);
            bl.setPower(x + y - r);
            br.setPower(x - y - r);
        } else {
            fl.setPower(0);
            fr.setPower(0);
            bl.setPower(0);
            br.setPower(0);
        }

     /*   if (gamepad1.dpad_right) {
            sr.setPower(1);
        }
        if (!gamepad1.dpad_right) {
            sr.setPower(0);
        }
        if (gamepad1.dpad_left) {
            sl.setPower(1);
        }
        if (!gamepad1.dpad_left) {
            sl.setPower(0);


        } */
    }
}
