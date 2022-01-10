package org.firstinspires.ftc.teamcode.OpModes.Autonomi.CarouselSide;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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
        driveTrain = DriveTrain.initDriveTrain(hardwareMap);
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

        grabber.setHeightTo(telemetry, 500);

        driveTrain.moveForwardsBy(telemetry, 3.5);
        driveTrain.turnToHeading(gyro, telemetry, -90);
        driveTrain.moveForwardsBy(telemetry, -12);
        driveTrain.turnToHeading(gyro, telemetry, 0);
        misc.toggleCarouselAuto();

        sleep(1000);
        driveTrain.moveForwardsBy(telemetry, 20);

    }
}