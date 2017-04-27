package com.springer.drawer.action

import com.springer.drawer.command.Command

case class Quit() extends Command with Action {

  override def executeAction(): Unit = {
    System.exit(1)
  }
}
