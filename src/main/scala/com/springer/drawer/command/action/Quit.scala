package com.springer.drawer.command.action

object Quit extends Action {

  override def execute(): Unit = {
    System.exit(1)
  }
}
