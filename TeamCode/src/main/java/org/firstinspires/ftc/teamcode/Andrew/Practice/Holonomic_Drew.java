package org.firstinspires.ftc.teamcode.Andrew.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Holonomic_Drew extends OpMode {
    DcMotor fl, bl, fr, br;
    CRServo sl, sr;
    Servo ns;
    @Override
    public void init() {
        fl = hardwareMap.dcMotor.get("fl");
        bl = hardwareMap.dcMotor.get("bl");
        fr = hardwareMap.dcMotor.get("fr");
        br = hardwareMap.dcMotor.get("br");
        sl = hardwareMap.crservo.get("sl");
        sr = hardwareMap.crservo.get("sr");
    }

    @Override
    public void loop() {
        float x = gamepad1.left_stick_x;
        float y = -gamepad1.left_stick_y;
        float r = gamepad1.right_stick_x;

        if (Math.abs(gamepad1.left_stick_y) > .01 || Math.abs(gamepad1.left_stick_x) > .01) {
            fl.setPower(-x - y - r);
            fr.setPower(-x + y - r);
            bl.setPower(x - y - r);
            br.setPower(x + y - r);
        }else {
            fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

        if (gamepad1.left_bumper = true){
            sl.setPower(1);
            sr.setPower(1);
        } else {
            sl.setPower(0);
            sr.setPower(0);
            if(gamepad1.right_bumper = true){
                sl.setPower(-1);
                sr.setPower(-1);
            } else  {
                sl.setPower(0);
                sr.setPower(0);

                if (gamepad1.a = true){
                    ns.setPosition(.5);



                }

            }

        }


    }
}