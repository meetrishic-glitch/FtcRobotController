package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class driveTrainPractice extends OpMode{
    testCode1 bench= new testCode1();
    @Override
    public void init() {
        bench.init(hardwareMap);

    }

    @Override
    public void loop() {
        double forward = -gamepad1.left_stick_y;
        double side = -gamepad1.left_stick_x;

        if (Math.abs(forward) < 0.05) forward = 0;
        if (Math.abs(side) < 0.05) side = 0;

        double rightBackPower = forward + side;
        double rightFrontPower = forward - side;
        double leftBackPower = forward - side;
        double leftFrontPower = forward + side;


        bench.setMoterSpeed("rightBack", rightBackPower);
        bench.setMoterSpeed("rightFront", rightFrontPower);
        bench.setMoterSpeed("leftBack", leftBackPower);
        bench.setMoterSpeed("leftFront", leftFrontPower);
        telemetry.addData("forward speed", forward);
        telemetry.addData("side speed", side);
        telemetry.update();
    }
}
