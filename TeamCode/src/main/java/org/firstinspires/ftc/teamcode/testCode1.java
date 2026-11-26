package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
public class testCode1 {
    private DcMotor leftBack;
    private DcMotor leftFront;
    private DcMotor rightBack;
    private DcMotor rightFront;
    private DcMotor flyWheel;
    public void init( HardwareMap hwMap) {

        telemetry.addLine("ready to run");
        telemetry.update();
        rightBack = hwMap.get(DcMotor.class, "rightBack");
        rightFront = hwMap.get(DcMotor.class, "rightFront");
        leftBack = hwMap.get(DcMotor.class, "leftBack");
        leftFront = hwMap.get(DcMotor.class, "leftFront");
        flyWheel = hwMap.get(DcMotor.class, "flyWheel");
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setMoterSpeed(String moterName, double speed) {
        //-1.0 to 1.0
        switch (moterName) {
            case "rightBack":
                rightBack.setPower(speed);
                break;
            case "rightFront":
                rightFront.setPower(speed);
                break;
            case "leftBack":
                leftBack.setPower(speed);
                break;
            case "leftFront":
                leftFront.setPower(speed);
                break;
            case "flyWheel":
                flyWheel.setPower(speed);
                break;
            case "all drive":
                rightBack.setPower(speed);
                rightFront.setPower(speed);
                leftBack.setPower(speed);
                leftFront.setPower(speed);
                break;
        }
    }
}