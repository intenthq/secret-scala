package com.intenthq.secret

import weaver.SimpleIOSuite

object SecretSpec extends SimpleIOSuite {

  case class NoSecret(value: String)

  pureTest("Secret.toString should hide its value by only showing a few chars of the SHA-1 hash") {
    expect(Secret("value").toString == "Secret(f32b67c)") and
      expect(Secret("newValue").toString == "Secret(74666ad)") and
      expect(Secret("myPassword").toString == "Secret(5413ee2)")
  }

}
