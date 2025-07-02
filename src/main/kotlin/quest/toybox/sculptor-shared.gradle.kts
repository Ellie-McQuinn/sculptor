package quest.toybox

import quest.toybox.sculptor.extension.SculptorExtension

plugins {
    java
    kotlin("jvm")
}

extensions.create<SculptorExtension>("sculptor")
