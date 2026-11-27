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
        double turn = gamepad1.right_stick_x;
        double side = gamepad1.left_stick_x;
        String sideDirection = null;

        if (Math.abs(forward) < 0.05) forward = 0;
        if (Math.abs(turn) < 0.05) turn = 0;
        if (Math.abs(side) < 0.05) side = 0;
        if (turn<0) sideDirection = "left";
        if (turn==0) sideDirection = null;
        if (turn>0) sideDirection = "right";

        double rightBackPower = forward + side - turn;
        double rightFrontPower = forward - side + turn;
        double leftBackPower = forward - side - turn;
        double leftFrontPower = forward + side + turn;


        bench.setMoterSpeed("rightBack", rightBackPower);
        bench.setMoterSpeed("rightFront", rightFrontPower);
        bench.setMoterSpeed("leftBack", leftBackPower);
        bench.setMoterSpeed("leftFront", leftFrontPower);
        telemetry.addData("forward speed", forward);
        telemetry.addData("side speed", side);
        telemetry.addData("turn speed", String.valueOf(side), sideDirection);
        telemetry.update();
    }
}
