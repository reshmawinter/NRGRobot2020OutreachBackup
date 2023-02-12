// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  private final Joystick leftJoystick = new Joystick(0);
  private final Joystick rightJoystick = new Joystick(1);
  private final CommandXboxController operatorController = new CommandXboxController(2);
  private final CommandXboxController driveController = new CommandXboxController(3);

  private final TankDrive drivetrain = new TankDrive();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // COMMENT OUT THE NEXT LINE TO USE XBOX CONTROLLER ON PORT 3
    drivetrain.setDefaultCommand(new DefaultDrive(drivetrain,leftJoystick::getY, rightJoystick::getY));

    // UNCOMMENT THIS LINE TO USE XBOX CONTROLLER
    //drivetrain.setDefaultCommand(new DefaultDrive(drivetrain,driveController::getLeftY, driveController::getRightY));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    operatorController.rightTrigger().whileTrue(new SetDriveSpeed(drivetrain));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  public Command getAutonomousCommand() {
    //return m_chooser.getSelected();
  }*/
}
