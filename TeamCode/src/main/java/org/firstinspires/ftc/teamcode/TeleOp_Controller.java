package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Testing_drive_train.DriveTrain;

@TeleOp (name = "Player Control")
public class TeleOp_Controller extends OpMode {

    DcMotor fr, fl, br, bl, arm;// claw, ramp, scoop;
//    CRServo lift, lifty_boi;
//    Servo cover1, cover2;
    Object x, y, z;


    @Override
    public void init() {


        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    @Override
    public void loop() {
        float x = gamepad1.left_stick_x;
        float y = -gamepad1.left_stick_y;
        float r = gamepad1.right_stick_x;

        DriveTrain Wheels = new DriveTrain();
        Wheels.init(hardwareMap);

        if (Math.abs(gamepad1.left_stick_x) > .1 || Math.abs(gamepad1.left_stick_y) > .1 || Math.abs(gamepad1.right_stick_x) > .1) {
            Wheels.DrivePower(x, y, r);
        }else {
            Wheels.DrivePower(0,0,0);
        }




    }
}
