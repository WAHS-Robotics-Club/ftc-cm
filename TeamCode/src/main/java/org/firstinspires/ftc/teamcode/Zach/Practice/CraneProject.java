package org.firstinspires.ftc.teamcode.Zach.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class CraneProject extends OpMode {
    DcMotor FrontLeftWheel, FrontRightWheel, BackLeftWheel, BackRightWheel;
    CRServo CraneLeft, CraneRight;

    @Override
    public void init() {
        FrontLeftWheel = hardwareMap.dcMotor.get("FrontRightWheel");
        FrontRightWheel = hardwareMap.dcMotor.get("FrontRightWheel");
        BackLeftWheel = hardwareMap.dcMotor.get("BackLeftWheel");
        BackRightWheel = hardwareMap.dcMotor.get("BackRightWheel");
        CraneLeft = hardwareMap.crservo.get("CraneLeft");
        CraneRight = hardwareMap.crservo.get("CraneRight");
        //bruh
    }

    @Override
    public void loop() {

        if (Math.abs(gamepad1.left_stick_y) > 0.01) {
            FrontLeftWheel.setPower(1);
            BackLeftWheel.setPower(1);
        } else {
            FrontLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            BackLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

        if (Math.abs(gamepad1.right_stick_y) > 0.01) {
            FrontRightWheel.setPower(1);
            BackRightWheel.setPower(1);
        } else {
            FrontRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            BackRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if (gamepad1.dpad_up = true) {
            CraneLeft.setPower(1);
            CraneRight.setPower(1);
        }if (gamepad1.dpad_up = false) {
            CraneLeft.setPower(0);
            CraneRight.setPower(0);
        }
        if (gamepad1.dpad_down = true) {
            CraneLeft.setPower(-1);
            CraneRight.setPower(-1);
        }
            if (gamepad1.dpad_down = false) {
                CraneLeft.setPower(0);
                CraneRight.setPower(0);
        }
    }
}