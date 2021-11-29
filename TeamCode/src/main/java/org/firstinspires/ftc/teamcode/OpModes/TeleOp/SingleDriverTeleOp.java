package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Objects.DriveTrain;
import org.firstinspires.ftc.teamcode.Objects.Grabber;
import org.firstinspires.ftc.teamcode.Objects.Misc;


@TeleOp(name ="Single Driver TeleOp - CM", group = "TeleOp")
public class SingleDriverTeleOp extends OpMode {
    //Initializing the servo objects:
    
    Grabber grabber;
    DriveTrain driveTrain;
    Misc misc;

    @Override
    public void init(){
        //Hardware mapping the servos:
        grabber = Grabber.initGrabber(hardwareMap);
        driveTrain = DriveTrain.initDriveTrain(hardwareMap);
        misc = Misc.initMiscellaneous(hardwareMap);

        driveTrain.resetEncoders();
        driveTrain.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override public void loop() {
        //Drive Train manual control system
        driveTrain.manualDrive(gamepad1);
        driveTrain.checkToggleSpeed(gamepad1);
        DriveTrain.logTelemetry(telemetry, driveTrain);

        //Grabber System (Servos)
        grabber.ManualToggleGrabber(gamepad1);

        //Spool controls
        grabber.ManualSpoolMotor(gamepad1);
        telemetry.addData("spool motor position", grabber.spoolMotor.getCurrentPosition());

        //Misc controls
        misc.checkTogglePosition(gamepad1);

    }

}