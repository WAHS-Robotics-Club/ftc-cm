package org.firstinspires.ftc.teamcode.OpModes.Autonomi.CarouselSide;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Objects.BananaFruit;
import org.firstinspires.ftc.teamcode.Objects.DriveTrain;
import org.firstinspires.ftc.teamcode.Objects.Grabber;
import org.firstinspires.ftc.teamcode.Objects.Misc;

@Autonomous(name ="Blue Side, Carousel - Autonomous")
public class BlueSideCarousel extends LinearOpMode {

    DriveTrain driveTrain;
    Grabber grabber;
    Misc misc;

    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain = DriveTrain.initDriveTrain(hardwareMap, DcMotor.ZeroPowerBehavior.BRAKE);
        grabber = Grabber.initGrabber(hardwareMap);
        misc = Misc.initMiscellaneous(hardwareMap);

        telemetry.addData("IsBusy", driveTrain.isBusy());
        driveTrain.logTelemetry(telemetry, driveTrain);
        telemetry.update();
        driveTrain.resetEncoders();
        BananaFruit gyro = new BananaFruit();
        gyro.runBananaFruit(hardwareMap, telemetry);
        telemetry.update();

        waitForStart();

        //ONLY MODIFY STUFF AFTER THIS

    /*  Grabber Commands:
        grabber.setHeightTo(telemetry, 500);
        grabber.toggleGrabberAuto();

        Drive Train Commands:
        driveTrain.moveForwardsBy(telemetry, 10);
        driveTrain.turnToHeading(gyro, telemetry, 90);

        Misc:
        sleep(1000);
        misc.toggleCarouselAuto();
    */
        //Sets up the correct carousel direction
        misc.toggleCarouselDirectionAuto();


        grabber.toggleGrabberAuto();
        grabber.setHeightTo(telemetry, 1000);

        //Pulls the robot out
        driveTrain.moveForwardsBy(telemetry, 6.5);
        //Makes it face away from the wall
        driveTrain.turnToHeading(gyro, telemetry, -90);
        //Makes it scootch back
        driveTrain.moveForwardsBy(telemetry, -18);


        //Carousel go brrr
        misc.toggleCarouselPowerAuto();
        sleep(10000);

        //Makes it go park
        driveTrain.turnToHeading(gyro, telemetry, 0);
        driveTrain.moveForwardsBy(telemetry, 19);
        driveTrain.turnToHeading(gyro, telemetry, -90);

        grabber.toggleGrabberAuto();
        driveTrain.moveForwardsBy(telemetry, -1);
        grabber.setHeightTo(telemetry, 0);

    }
}