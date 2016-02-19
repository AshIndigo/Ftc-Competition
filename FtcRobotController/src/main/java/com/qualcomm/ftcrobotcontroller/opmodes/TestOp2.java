package com.qualcomm.ftcrobotcontroller.opmodes;

import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class TestOp2 extends PushBotTelemetry {

    Servo lHand;
    Servo rHand;

    public TestOp2() {

    }

    @Override public void loop () {

        lHand = hardwareMap.servo.get("right_hand");

        rHand = hardwareMap.servo.get("left_hand");

        DcMotor rightArm = hardwareMap.dcMotor.get("right_arm");

        double l_left_drive_power = scale_motor_power(gamepad1.left_stick_y);

        double l_right_drive_power = scale_motor_power(gamepad1.right_stick_y);

        set_drive_power(l_right_drive_power, l_left_drive_power);

        float l_left_arm_power = gamepad2.left_stick_y;
        m_left_arm_power(l_left_arm_power / 2);

        float l_right_arm_power = gamepad2.right_stick_y;
        rightArm.setPower(l_right_arm_power * -1);

        if (gamepad2.left_bumper) {
                rHand.setPosition(1);
                lHand.setPosition(0);
        }

        if (gamepad2.right_bumper) {
                rHand.setPosition(0);
                lHand.setPosition(1);
        }
            if (gamepad2.right_trigger != 0) {
                rHand.setPosition(.5);
                lHand.setPosition(.5);
            }

        update_telemetry(); // Update common telemetry
        update_gamepad_telemetry();
        telemetry.addData
                ("12"
                        , "Left Arm: " + l_left_arm_power
                );
            telemetry.addData
                ("13"
                        , "Right Arm: " + l_right_arm_power
                );
            telemetry.addData
                ("14"
                        , "Left Servo Pos: " + lHand.getPosition()
                );
            telemetry.addData
                ("15"
                        , "Right Servo Pos: " + rHand.getPosition()
                );



    }
}
