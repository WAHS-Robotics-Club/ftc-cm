package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous (name = "AutonomousBlue")
public class Autonomous_Blue extends LinearOpMode {
    DcMotor FrontLeft, FrontRight, BackLeft, BackRight;

    CRServo Ramp, Claw1, Claw2;



    @Override
    public void runOpMode() throws InterruptedException {

        FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");

        Ramp = hardwareMap.crservo.get("Ramp");
        Claw1 = hardwareMap.crservo.get("Claw1");
        Claw2 = hardwareMap.crservo.get("Claw2");

        waitForStart();

        FrontLeft.setPower(1);
        FrontRight.setPower(1);
        BackLeft.setPower(1);
        BackRight.setPower(1);

        wait(1000);

        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);


    }
}
