// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Turret;

public class ShuffleBoard extends SubsystemBase {
  /** Creates a new ShuffleBoard. */
  public ShuffleBoard() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static ShuffleboardTab getTab(String string) {
    return null;
  }
}

