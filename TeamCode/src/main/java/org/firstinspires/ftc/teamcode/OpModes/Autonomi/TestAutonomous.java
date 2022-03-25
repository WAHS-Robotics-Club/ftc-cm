package org.firstinspires.ftc.teamcode.OpModes.Autonomi;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Objects.BananaFruit;
import org.firstinspires.ftc.teamcode.Objects.DriveTrain;
import org.firstinspires.ftc.teamcode.Objects.Grabber;
import org.firstinspires.ftc.teamcode.Objects.Misc;

@Autonomous(name ="Test Autonomous - Autonomous")
public class TestAutonomous extends LinearOpMode {

    DriveTrain driveTrain;

    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain = DriveTrain.initDriveTrain(hardwareMap, DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("IsBusy", driveTrain.isBusy());
        driveTrain.logTelemetry(telemetry, driveTrain);
        telemetry.update();
        driveTrain.resetEncoders();
        BananaFruit gyro = new BananaFruit();
        gyro.runBananaFruit(hardwareMap, telemetry);
        telemetry.update();

        waitForStart();

        //ONLY MODIFY STUFF AFTER THIS



        driveTrain.moveForwardsBy(telemetry, 12);

        sleep(1000);

        driveTrain.moveForwardsBy(telemetry, 12);

        driveTrain.turnToHeading(gyro, telemetry, 90);
        driveTrain.moveForwardsBy(telemetry, 12);

        driveTrain.turnToHeading(gyro, telemetry, 180);
        driveTrain.moveForwardsBy(telemetry, 12);

        driveTrain.turnToHeading(gyro, telemetry, -90);
        driveTrain.moveForwardsBy(telemetry, 12);

        driveTrain.turnToHeading(gyro, telemetry, 0);
        driveTrain.moveForwardsBy(telemetry, -12);

        driveTrain.turnToHeading(gyro, telemetry, 90);
        driveTrain.moveForwardsBy(telemetry, -12);

        //STILL REQUIRES TESTING
    }
}