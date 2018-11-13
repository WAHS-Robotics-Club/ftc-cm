package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "Player Control")
public class TeleOp_Controller extends OpMode {

    DcMotor fr, fl, br, bl; //lift;
    Servo S1, S2;
    Object x, y, z;

    @Override
    public void init() {

        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");
        //       lift = hardwareMap.dcMotor.get("lift");

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    @Override
    public void loop() {
        float x = gamepad1.left_stick_x;
        float y = -gamepad1.left_stick_y;
        float r = gamepad1.right_stick_x;

        if (Math.abs(gamepad1.left_stick_x) > .1 || Math.abs(gamepad1.left_stick_y) > .1 || Math.abs(gamepad1.right_stick_x) > .1) {
            fl.setPower(-x - y - r);
            fr.setPower(-x + y - r);
            bl.setPower(x - y - r);
            br.setPower(x + y - r);
        }else {
            fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }


//        if (gamepad2.right_bumper = true){
//            lift.setPower(.6);
//        }else {
//            if (gamepad2.left_bumper = true){
//                lift.setPower(-.4);
//            }
//        }
    }
}