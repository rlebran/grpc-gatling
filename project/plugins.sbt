// comment to get more information during initialization
logLevel := Level.Warn

// gatling perforamce test
addSbtPlugin("io.gatling" % "gatling-sbt" % "2.2.2")

// shows sbt project dependency updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.4")

libraryDependencies += "com.thesamet.scalapb" %% "compilerplugin" % "0.7.2"

