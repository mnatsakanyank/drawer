package com.springer.command

import com.springer.drawer.command.CommandFactory

class CommandFactoryTest extends org.scalatest.FunSuite {

  test("An empty Set should have size 0") {
    CommandFactory.parseInput("test")
  }

}
