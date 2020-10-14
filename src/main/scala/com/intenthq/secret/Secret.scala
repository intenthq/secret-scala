package com.intenthq.secret

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

final case class Secret(value: String) {
  override val toString: String = s"Secret(${Secret.firstSevenHashChars(value)})"
}

object Secret {

  protected def firstSevenHashChars(s: String): String = {
    // DO NOT EXTRACT THIS VAL OUT. MessageDigest keeps internal state and if you extract it, things will become flaky
    val md: MessageDigest = java.security.MessageDigest.getInstance("SHA-1")
    md.digest(s.getBytes(StandardCharsets.UTF_8)).map("%02x".format(_)).mkString.take(7)
  }

}
