package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Objects.DriveTrain;
import org.firstinspires.ftc.teamcode.Objects.Grabber;
import org.firstinspires.ftc.teamcode.Objects.Misc;


@TeleOp(name ="Dual Driver TeleOp - HME", group = "TeleOp")
public class DualDriverTeleOp extends OpMode {
    //Initializing the servo objects:
    Grabber grabber;
    DriveTrain driveTrain;
    Misc misc;

    @Override
    public void init(){
        //Hardware mapping the servos:
        grabber = Grabber.initGrabber(hardwareMap);
        driveTrain = DriveTrain.initDriveTrain(hardwareMap);
    }

    /*
    leftFront = 2
    leftBack = 1
    rightFront = 3
    rightBack = 0
    */

    //Elijah was here! And here too!
    @Override public void loop(){
        //Drive Train manual control system
        driveTrain.manualDrive(gamepad1);
        driveTrain.checkToggleSpeed(gamepad1);
        DriveTrain.logTelemetry(telemetry, driveTrain);

        //Grabber System (Servos)
        grabber.ManualToggleGrabber(gamepad1);
        telemetry.addData("spool motor position", grabber.spoolMotor.getCurrentPosition());

        //Spool controls
        grabber.ManualSpoolMotor(gamepad2);

        //Misc controls
        misc.checkTogglePosition(gamepad2);
    }

}