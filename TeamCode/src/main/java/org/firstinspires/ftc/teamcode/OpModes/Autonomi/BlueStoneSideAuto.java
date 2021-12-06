package org.firstinspires.ftc.teamcode.OpModes.Autonomi;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Objects.BananaFruit;
import org.firstinspires.ftc.teamcode.Objects.DriveTrain;
import org.firstinspires.ftc.teamcode.Objects.Grabber;
import org.firstinspires.ftc.teamcode.Objects.Misc;

@Autonomous(name ="BlueStoneSide - Autonomous", group = "Blue Side")
public class BlueStoneSideAuto extends LinearOpMode {

    DriveTrain driveTrain;
    Grabber grabber;
    Misc misc;

    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain = DriveTrain.initDriveTrain(hardwareMap);
        grabber = Grabber.initGrabber(hardwareMap);

        telemetry.addData("IsBusy", driveTrain.isBusy());
        driveTrain.logTelemetry(telemetry, driveTrain);
        telemetry.update();
        driveTrain.resetEncoders();
        BananaFruit gyro = new BananaFruit();
        gyro.runBananaFruit(hardwareMap, telemetry);
        telemetry.update();

        waitForStart();

        //ONLY MODIFY STUFF AFTER THIS

        //Sets the height to a safe height
        grabber.setHeightTo(telemetry, 500);
        //The encoders on everything except the spool motor reset each time you run it


        //Setting servos and motors to the correct position
        grabber.checkToggleGrabber();
        sleep(1000);

        driveTrain.moveForwardsBy(telemetry, 10);

        grabber.forceToggleGrabber();
        grabber.checkToggleGrabber();
        sleep(1000);

        grabber.setHeightTo(telemetry, 10000);

        driveTrain.moveForwardsBy(telemetry, -5);

        driveTrain.turnToHeading(gyro, telemetry, 90);

        driveTrain.moveForwardsBy(telemetry, 5);

        grabber.forceToggleGrabber();
        grabber.checkToggleGrabber();
        sleep(1000);

        driveTrain.moveForwardsBy(telemetry, -5);

        grabber.setHeightTo(telemetry, 0);

        sleep(2500);

        //STILL REQUIRES TESTING
    }
}