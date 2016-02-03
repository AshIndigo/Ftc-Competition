package com.qualcomm.ftcrobotcontroller.opmodes;

import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class TestOp extends PushBotTelemetry {

    public TestOp() {

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
        rightArm.setPower(l_right_arm_power);

        if (gamepad1.x) {
            rHand.setPosition(rHand.getPosition() + .05);
            lHand.setPosition(lHand.getPosition() - .05);
        } else if (gamepad1.b) {
            rHand.setPosition(rHand.getPosition() - .05);
            lHand.setPosition(lHand.getPosition() + .05);
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
