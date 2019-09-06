package org.firstinspires.ftc.teamcode.last_year.Testing_drive_train;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {
    DcMotor FrontLeft, FrontRight, BackLeft, BackRight;

    public void init(HardwareMap hwMap) {
        FrontLeft = hwMap.dcMotor.get("fl");
        FrontRight = hwMap.dcMotor.get("fr");
        BackLeft = hwMap.dcMotor.get("bl");
        BackRight = hwMap.dcMotor.get("br");
    }

    public void loop() {
    }

    public void DrivePower(double LeftStickX, double LeftStickY, double RightStickX) {
        FrontLeft.setPower(LeftStickX + LeftStickY - RightStickX);
        FrontRight.setPower(LeftStickY - LeftStickY - RightStickX);
        BackLeft.setPower(-LeftStickX + LeftStickY - RightStickX);
        BackRight.setPower(-LeftStickX - LeftStickY - RightStickX);

    }
}


