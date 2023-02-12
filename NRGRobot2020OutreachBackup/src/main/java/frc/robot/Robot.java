// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  //private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private final PWMVictorSPX m_leftMotor1 = new PWMVictorSPX(2);
  private final PWMVictorSPX m_rightMotor1 = new PWMVictorSPX(0);
  private final PWMVictorSPX m_leftMotor2 = new PWMVictorSPX(3);
  private final PWMVictorSPX m_rightMotor2 = new PWMVictorSPX(1);
  private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
  private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
/**
            public static final int kLeftMotor1Port = 3;
        public static final int kLeftMotor2Port = 4;
        public static final int kRightMotor1Port = 1;
        public static final int kRightMotor2Port = 2;
*/
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  }
  @Override
  public void teleopPeriodic() {
    
    m_rightMotors.setInverted(true);

    m_leftMotors.set(m_leftStick.getY());
    m_rightMotors.set(m_rightStick.getY());
    //m_leftMotor2.set(-m_leftStick.getY());
    //m_rightMotor2.set(m_rightStick.getY());
  }
}