// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;

public class RobotContainer {

  private final CommandJoystick leftJoystick = new CommandJoystick(2);
  private final CommandJoystick rightJoystick = new CommandJoystick(3);
  private final CommandXboxController operatorController = new CommandXboxController(1);
  private final CommandXboxController driveController = new CommandXboxController(0);

  //private final RobotController m_robotController;

  private final TankDrive drivetrain = new TankDrive();
  private final Intake intaker = new Intake();
  private final Feeder feeder = new Feeder();
  private final Hood hood = new Hood();
  private final Turret turret = new Turret();
  private final ShooterRPM rpm = new ShooterRPM();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    intaker.setDefaultCommand(new ControlIntake(intaker, operatorController));
    feeder.setDefaultCommand(new ControlFeeder(feeder, operatorController));
    hood.setDefaultCommand(new ControlHood(hood, operatorController));
    turret.setDefaultCommand(new ControlTurret(turret, operatorController));
    rpm.setDefaultCommand(new ManualShooter(rpm, operatorController));

    drivetrain.setDefaultCommand(new DefaultDrive(drivetrain,leftJoystick, rightJoystick,driveController));
    /**ShuffleboardTab turretTab = Shuffleboard.getTab("Information"); // creates tab called Information on Shuffle board
    turretTab.add("Turret Heading", Turret.getHeading()) // adds a Turret Heading widget
    .withPosition(1, 1) // puts the Turret Heading widget at column and row index 1
    .withSize(2, 1) // makes the Turret Heading widget 2 wide and 1 high
    .getEntry(); 

    ShuffleboardTab hoodTab = Shuffleboard.getTab("Information");
    hoodTab.add("Hood Heading", Hood.getHeading())
    .withPosition(3, 1)
    .withSize(2, 1);

    drivetrain.setDefaultCommand(new DefaultDrive(drivetrain, leftJoystick, rightJoystick, driveController));
    ShuffleboardTab operatorTab = Shuffleboard.getTab("Operator");
    operatorTab.add("Operator", operatorTab) // adds a Turret Heading widget
    .withPosition(1, 1) // puts the Turret Heading widget at column and row index 1
    .withSize(2, 1) // makes the Turret Heading widget 2 wide and 1 high
    .getEntry(); **/

  }   

  

  // private void getEntry() {
  // }



  // private Sendable preferencesTab() {
  //   ShuffleboardTab preferencesTab = Shuffleboard.getTab("Preferences");
  //   preferencesTab.add("YasQueen", preferencesTab())
  //   .withPosition(1, 1)
  //   .withSize(2, 1);
  //   return null;
  // }



  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    operatorController.leftTrigger().whileTrue(new SetDriveSpeed(drivetrain));
    
    //m_robotController.getUserButton().debounce(0.1).onTrue(new SetDriveMode());
    //fails to build

    //TODO: Add the user button command
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  public Command getAutonomousCommand() {
    //return m_chooser.getSelected();
  }*/
}
