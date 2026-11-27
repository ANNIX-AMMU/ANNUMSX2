package com.armsx2.enumsx2
import com.armsx2.config.Settings
import org.junit.Assert.*
import org.junit.Test
class Enumsx2GraphicsProfilesTest {
 @Test fun performance(){val s=Enumsx2GraphicsProfiles.performance(Settings());assertEquals(1.0f,s.output.upscaleFloat);assertFalse(s.graphics.disableShaderCache);assertTrue(s.display.coalesceRenderPasses)}
 @Test fun quality(){val s=Enumsx2GraphicsProfiles.quality(Settings());assertEquals(2.0f,s.output.upscaleFloat);assertEquals(2,s.graphics.accurateBlendingUnit);assertEquals(0,s.graphics.hardwareDownloadMode)}
 @Test fun compatibility(){val s=Enumsx2GraphicsProfiles.compatibility(Settings());assertFalse(s.hwFixes.manualUserHacks);assertEquals(0,s.hwFixes.skipDrawStart);assertEquals(0,s.hwFixes.skipDrawEnd)}
}
