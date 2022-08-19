package Lectures.part2oop

object Enums  {

  // Data type that only have enumerated constant instances
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // You can add fields/methods

    def openDocument(): Unit =
      if (this == READ) println("Opening Document...")
      else println("Reading not allowed")
  }

  val somePermissions: Permissions = Permissions.READ

  // Can also take constructor Args

  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits =
      PermissionsWithBits.NONE
  }

  // Standard API for enums

  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values //array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ")

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionsOrdinal)
    println(allPermissions)
    print(readPermission)
  }
}
