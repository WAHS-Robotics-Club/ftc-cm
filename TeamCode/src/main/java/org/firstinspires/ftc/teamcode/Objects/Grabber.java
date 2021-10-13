package org.firstinspires.ftc.team9202hme.Objects;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.team9202hme.Tool.Toggle;

public class Grabber {
    public Servo leftServo;
    public Servo rightServo;

    public DcMotor spoolMotor;

    private Toggle toggleGrabber;

    public static Grabber initGrabber(HardwareMap hardwareMap){
        //Creates and hardware maps the grabber element
        Grabber grabber = new Grabber();

        grabber.leftServo = hardwareMap.servo.get("leftServo");
        grabber.rightServo = hardwareMap.servo.get("rightServo");

        grabber.spoolMotor = hardwareMap.dcMotor.get("spoolMotor");
        grabber.toggleGrabber = new Toggle();
        grabber.spoolMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        grabber.spoolMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        return grabber;
    }

    public void CheckToggleGrabber(){
        if(toggleGrabber.isToggled()){
            rightServo.setPosition(0.05);
            leftServo.setPosition(0.95);
        }else{
            rightServo.setPosition(1);
            leftServo.setPosition(0);
        }
    }
    public void setHeightTo(Telemetry telemetry, int targetPosition) throws InterruptedException{
        Thread.sleep(1);

        spoolMotor.setPower(.8);
        spoolMotor.setTargetPosition(targetPosition);
        spoolMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        int i = 0;
        while(spoolMotor.isBusy() && i < 500){
            telemetry.update();
            i++;
            Thread.sleep(1);
        }
    }

    public void ManualToggleGrabber(Gamepad gamepad1){
        if(gamepad1.right_bumper) {
            toggleGrabber.toggle();
        }
        CheckToggleGrabber();
    }

    public void ManualSpoolMotor(Gamepad gamepad) {
        //Moves the arm up and down
        if(gamepad.right_trigger >= 0.1 && gamepad.left_trigger >= 0.1){
            SpoolMotorControl(0, gamepad);
        }else if(gamepad.right_trigger >= 0.1){
            SpoolMotorControl(gamepad.right_trigger, gamepad);
        }else if(gamepad.left_trigger >= 0.1){
            SpoolMotorControl(-gamepad.left_trigger, gamepad);
        }else{
            SpoolMotorControl(0, gamepad);
        }
    }

    private void SpoolMotorControl(float Power, Gamepad gamepad){
        if (spoolMotor.getCurrentPosition() < 12300 && spoolMotor.getCurrentPosition() > -10 || gamepad.dpad_right) {
            if (Math.abs(Power) >= 0.1) {
                spoolMotor.setPower(Power);
            } else {
                spoolMotor.setPower(0);
            }
        }else if(spoolMotor.getCurrentPosition() > -10){
            spoolMotor.setPower(-.2);
        }else{
            spoolMotor.setPower(.2);
        }

        if(gamepad.dpad_up){
            spoolMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            for(int i = 0; i < 100; i++){/*slow down*/}
            spoolMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }


}