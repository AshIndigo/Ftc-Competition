package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by 19jasonides_a on 06/02/16.
 */
public class TeleOp extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {

        DcMotor leftMotor = hardwareMap.dcMotor.get("left_drive");
        DcMotor rightMotor = hardwareMap.dcMotor.get("right_drive");
        DcMotor arm = hardwareMap.dcMotor.get("arm");
        DcMotor tape = hardwareMap.dcMotor.get("tape_extendor");
        Servo leftGripper = hardwareMap.servo.get("left_hand");
        Servo rightGripper = hardwareMap.servo.get("right_hand");

        double l_left_drive_power = this.scale_motor_power(-gamepad1.left_stick_y);

        double l_right_drive_power = this.scale_motor_power(gamepad1.right_stick_y);

        leftMotor.setPower(l_left_drive_power);
        rightMotor.setPower(l_right_drive_power);

        if (gamepad1.y) {
            arm.setPower(.4);
        } else if (gamepad1.b) {
            arm.setPower(-.4);
        } else {
            arm.setPower(0);
        }

        if (gamepad2.x) {
            tape.setPower(1);
        } else if (gamepad2.a) {
            tape.setPower(-1);
        } else {
            tape.setPower(0);
        }

        if (gamepad2.b) {
            leftGripper.setPosition(0);
            rightGripper.setPosition(1);
        } else {
            leftGripper.setPosition(.5);
            rightGripper.setPosition(.5);
        }


    }

    float scale_motor_power(float p_power) {
        //
        // Assume no scaling.
        //
        float l_scale = 0.0f;

        //
        // Ensure the values are legal.
        //
        float l_power = Range.clip(p_power, -1, 1);

        float[] l_array =
                {0.00f, 0.05f, 0.09f, 0.10f, 0.12f
                        , 0.15f, 0.18f, 0.24f, 0.30f, 0.36f
                        , 0.43f, 0.50f, 0.60f, 0.72f, 0.85f
                        , 1.00f, 1.00f
                };

        //
        // Get the corresponding index for the specified argument/parameter.
        //
        int l_index = (int) (l_power * 16.0);
        if (l_index < 0) {
            l_index = -l_index;
        } else if (l_index > 16) {
            l_index = 16;
        }

        if (l_power < 0) {
            l_scale = -l_array[l_index];
        } else {
            l_scale = l_array[l_index];
        }

        return l_scale;
    }
}
