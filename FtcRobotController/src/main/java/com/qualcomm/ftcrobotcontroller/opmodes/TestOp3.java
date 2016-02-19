package com.qualcomm.ftcrobotcontroller.opmodes;

import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class TestOp3 extends PushBotTelemetry {

    public TestOp3() {

    }

    @Override public void loop ()

    {
        Servo lHand = hardwareMap.servo.get("right_hand");

        Servo rHand = hardwareMap.servo.get("left_hand");

        DcMotor rightArm = hardwareMap.dcMotor.get("right_arm");

        double l_left_drive_power = scale_motor_power(gamepad1.left_stick_y);

        double l_right_drive_power = scale_motor_power(gamepad1.right_stick_y);

        set_drive_power(l_left_drive_power, l_right_drive_power);

        float l_left_arm_power = gamepad2.left_stick_y;
        m_left_arm_power(l_left_arm_power);

        float l_right_arm_power = gamepad2.right_stick_y;
        rightArm.setPower(l_right_arm_power * -1);

        if (gamepad1.x) {
            if (rHand.getPosition() > .05 && rHand.getPosition() != 0) {
                if (lHand.getPosition() > .05 && lHand.getPosition() != 0) {
                    rHand.setPosition(rHand.getPosition() + .01);
                    lHand.setPosition(lHand.getPosition() - .01);
                } else {
                    lHand.setPosition(0);
                }
            } else {
                rHand.setPosition(0);
            }
        }

        if (gamepad1.b) {
            if (rHand.getPosition() > .05 && rHand.getPosition() != 0) {
                if (lHand.getPosition() > .05 && lHand.getPosition() != 0) {
                    rHand.setPosition(rHand.getPosition() - .01);
                    lHand.setPosition(lHand.getPosition() + .01);
                } else {
                    lHand.setPosition(0);
                }
            } else {
                rHand.setPosition(0);
            }
        }

        //m_hand_position(0);

        update_telemetry(); // Update common telemetry
        update_gamepad_telemetry();
        telemetry.addData
                ("12"
                        , "Left Arm: " + l_left_arm_power
                );
        // /*
        telemetry.addData
                ("13"
                        , "Right Arm: " + l_right_arm_power
                );
        //*/


    }

}
