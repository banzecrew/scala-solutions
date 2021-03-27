object Flags {
  var flags: Byte = 0

  val _flag0 = 0x01
  val _flag1 = 0x02
  val _flag2 = 0x04
  val _flag3 = 0x08
  val _flag4 = 0x10
  val _flag5 = 0x20
  val _flag6 = 0x40
  val _flag7 = 0x80

  @inline def setFlag(flag: Int): Boolean =
    (this.flags | flag).toByte match {
      case newFlags if newFlags != this.flags =>
        this.flags = newFlags
        true
      case _ => false
    }

  @inline def removeFlag(flag: Int): Boolean =
    (this.flags & ~flag).toByte match {
      case newFlags if newFlags != flags =>
        this.flags = newFlags
        true
      case _ => false
    }

  @inline def checkFlag(flag: Int): Boolean =
    (flag & this.flags) == flag
}